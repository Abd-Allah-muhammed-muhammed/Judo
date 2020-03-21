package com.example.judo.adapters;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.judo.R;
import com.example.judo.databinding.ItemCoursesBinding;
import com.example.judo.databinding.ItemNewsBinding;
import com.example.judo.model.courses.CoursesModel;
import com.example.judo.model.news_item.NewsItemModel;
import com.example.judo.ui.courses.details.CoursesDetailsFragment;
import com.example.judo.ui.news_details.NewsDetailsFragment;

import java.util.ArrayList;
import java.util.List;

import static com.example.judo.helper.HelperMethods.replace;


public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.VH>{

    private List<CoursesModel> list = new ArrayList<>();
    private Context context ;
    private Activity activity ;

    public CoursesAdapter(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public CoursesAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        this.context = parent.getContext();

        ItemCoursesBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_courses,parent,false);

        return new VH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final CoursesAdapter.VH holder, int position) {


        CoursesModel  coursesModel = list.get(position);
        holder.binding.setCourse(coursesModel);
        ImageView topicImage = holder.binding.topicImage;
        Glide.with(context).load(coursesModel.getImage()).into(topicImage);
        holder.binding.cardItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                replace(CoursesDetailsFragment.newInstance(),R.id.container_courses,((FragmentActivity)context).getSupportFragmentManager().beginTransaction(),"courses_details");
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


public void setCourses(List<CoursesModel> list){

        this.list = list;
        notifyDataSetChanged();

}

    public class VH  extends   RecyclerView.ViewHolder{
        ItemCoursesBinding binding ;
        public VH(@NonNull ItemCoursesBinding itemView) {
            super(itemView.getRoot());
            this.binding =itemView;
        }
    }



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void openCoursesDetails(ImageView image) {

//        ActivityOptionsCompat compat = null;
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
//            compat = ActivityOptionsCompat.makeSceneTransitionAnimation( activity,image, Objects.requireNonNull(ViewCompat.getTransitionName(image)));
//        }

//        replace(new NewsDetailsFragment(),R.id.news_container,((FragmentActivity)context).getSupportFragmentManager().beginTransaction(),"newsDetails");
    }

}
