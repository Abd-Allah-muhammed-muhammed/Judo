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
import com.example.judo.databinding.ItemCopetitionsBinding;
import com.example.judo.databinding.ItemCoursesBinding;
import com.example.judo.model.copmetitions.CompetitionModel;
import com.example.judo.model.courses.CoursesModel;
import com.example.judo.ui.courses.details.CoursesDetailsFragment;

import java.util.ArrayList;
import java.util.List;

import static com.example.judo.helper.HelperMethods.replace;


public class CompetitionsAdapter extends RecyclerView.Adapter<CompetitionsAdapter.VH>{

    private List<CompetitionModel> list = new ArrayList<>();
    private Context context ;
    private Activity activity ;

    public CompetitionsAdapter(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public CompetitionsAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        this.context = parent.getContext();

        ItemCopetitionsBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_copetitions,parent,false);

        return new VH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final CompetitionsAdapter.VH holder, int position) {


        CompetitionModel competitionModel = list.get(position);
        holder.binding.setCompetitions(competitionModel);

        if (competitionModel.isOfficial()){

            holder.binding.isOfficial.setImageResource(R.drawable.tag);
        }else {
            holder.binding.isOfficial.setImageResource(R.drawable.tag2);


        }

        Glide.with(context).load(competitionModel.getImage()).into(holder.binding.topicImage);
        holder.binding.competitionCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


public void setCompetitions(List<CompetitionModel> list){

        this.list = list;
        notifyDataSetChanged();

}

    public class VH  extends   RecyclerView.ViewHolder{
        ItemCopetitionsBinding binding ;
        public VH(@NonNull ItemCopetitionsBinding itemView) {
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
