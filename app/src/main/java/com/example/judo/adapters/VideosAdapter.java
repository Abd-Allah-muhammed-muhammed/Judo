package com.example.judo.adapters;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
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
import com.example.judo.databinding.ItemNewsBinding;
import com.example.judo.databinding.ItemVediosBinding;
import com.example.judo.model.news_item.NewsItemModel;
import com.example.judo.model.videos.VideosModel;
import com.example.judo.ui.news_details.NewsDetailsFragment;
import com.example.judo.ui.vedios.play_video.PlayVideoFragment;

import java.util.ArrayList;
import java.util.List;

import static com.example.judo.helper.HelperMethods.replace;


public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.VH>{

    private List<VideosModel> list = new ArrayList<>();
    private Context context ;
    private Activity activity ;

    public VideosAdapter(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public VideosAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        this.context = parent.getContext();

        ItemVediosBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_vedios,parent,false);

        return new VH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final VideosAdapter.VH holder, int position) {


        final VideosModel videosModel = list.get(position);

        holder.binding.setVideos(videosModel);

        Glide.with(holder.itemView).load(videosModel.getImage()).into(holder.binding.imageVideos);


        holder.binding.cardVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("video",videosModel.getVideo());

                PlayVideoFragment fragment = new PlayVideoFragment();

                fragment.setArguments(bundle);
                replace(fragment,R.id.hom_container,((FragmentActivity)context).getSupportFragmentManager().beginTransaction(),
                        "play_video");
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


public void setVideos(List<VideosModel> list){
        this.list = list;
        notifyDataSetChanged();

}

    public class VH  extends   RecyclerView.ViewHolder{
        ItemVediosBinding binding ;
        public VH(@NonNull ItemVediosBinding itemView) {
            super(itemView.getRoot());
            this.binding =itemView;
        }
    }




}
