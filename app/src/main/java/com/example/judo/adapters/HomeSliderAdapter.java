package com.example.judo.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.judo.R;
import com.example.judo.model.SliderModelHome;
import com.example.judo.ui.news.NewsActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class HomeSliderAdapter extends RecyclerView.Adapter<HomeSliderAdapter.VH> {
    private Context context;
    private Activity activity ;
    private List<SliderModelHome> list = new ArrayList<>();

    public List<SliderModelHome> getList() {
        return list;
    }

    public void setList(List<SliderModelHome> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public HomeSliderAdapter(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        return new VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slider, parent, false), list);
    }

    @Override
    public void onBindViewHolder(@NonNull final VH holder, int position) {
        String url=list.get(position).getImage();

        Glide.with(context).load(url).into(holder.imageView);

        String title = list.get(position).getTitle();
        holder.title.setText(title);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openNewsActivity(holder.imageView);


            }
        });
    }

    private void openNewsActivity(ImageView image) {


        Intent intent = new Intent(activity, NewsActivity.class);
        ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation( activity,image, Objects.requireNonNull(ViewCompat.getTransitionName(image)));
        context.startActivity(intent,compat.toBundle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class VH extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView  title ;

        VH(@NonNull View itemView, final List<SliderModelHome> list) {
            super(itemView);

            imageView=itemView.findViewById(R.id.image_view);
            title=itemView.findViewById(R.id.title_view);
        }
    }
}
