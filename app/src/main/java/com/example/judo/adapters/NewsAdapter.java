package com.example.judo.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.judo.R;
import com.example.judo.databinding.ItemNewsBinding;
import com.example.judo.model.news_item.NewsItemModel;
import com.example.judo.ui.news.NewsActivity;
import com.example.judo.ui.news_details.NewsDetailsFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.judo.helper.HelperMethods.replace;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.VH>{

    private List<NewsItemModel> list = new ArrayList<>();
    private Context context ;
    private Activity activity ;

    public NewsAdapter(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public NewsAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        this.context = parent.getContext();

        ItemNewsBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_news,parent,false);

        return new VH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final NewsAdapter.VH holder, int position) {


        NewsItemModel newsItemModel = list.get(position);
        holder.binding.setNews(newsItemModel);
        Glide.with(holder.itemView).load(newsItemModel.getImage()).into(holder.binding.imageNews);

        holder.binding.imageNews.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                openNewsDetails(holder.binding.imageNews);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


public void setNews(List<NewsItemModel> list){

        this.list = list;
        notifyDataSetChanged();

}

    public class VH  extends   RecyclerView.ViewHolder{
        ItemNewsBinding binding ;
        public VH(@NonNull ItemNewsBinding itemView) {
            super(itemView.getRoot());
            this.binding =itemView;
        }
    }



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void openNewsDetails(ImageView image) {

//        ActivityOptionsCompat compat = null;
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
//            compat = ActivityOptionsCompat.makeSceneTransitionAnimation( activity,image, Objects.requireNonNull(ViewCompat.getTransitionName(image)));
//        }

        replace(new NewsDetailsFragment(),R.id.news_container,((FragmentActivity)context).getSupportFragmentManager().beginTransaction(),"newsDetails");
    }

}
