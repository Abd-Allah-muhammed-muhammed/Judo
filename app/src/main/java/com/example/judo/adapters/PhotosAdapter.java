package com.example.judo.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.judo.R;
import com.example.judo.databinding.ItemCompetitionPhotosBinding;
import com.example.judo.databinding.ItemCopetitionsBinding;
import com.example.judo.databinding.ItemVediosBinding;
import com.example.judo.model.photos.PhotosModel;
import com.example.judo.model.videos.VideosModel;
import com.example.judo.ui.competitions.details.photos.show_photos.ShowPhotoActivity;
import com.example.judo.ui.vedios.play_video.PlayVideoFragment;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.judo.helper.HelperMethods.replace;


public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.VH>{

    private List<PhotosModel> list = new ArrayList<>();
    private Context context ;
    private Activity activity ;

    public PhotosAdapter(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public PhotosAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        this.context = parent.getContext();

        ItemCompetitionPhotosBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_competition_photos,parent,false);

        return new VH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final PhotosAdapter.VH holder, int position) {


        final PhotosModel photosModel = list.get(position);

        Glide.with(holder.itemView).load(photosModel.getImage()).into(holder.binding.imageCompetition);

       final RoundedImageView image = holder.binding.imageCompetition;
        holder.binding.imageCompetition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ActivityOptionsCompat compat = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                    compat = ActivityOptionsCompat.makeSceneTransitionAnimation( activity,image, Objects.requireNonNull(ViewCompat.getTransitionName(image)));
                }
                Intent intent = new Intent(activity,ShowPhotoActivity.class);
        intent.putExtra("imag_comp",photosModel.getImage());

        context.startActivity(intent,compat.toBundle());

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


public void setPhotos(List<PhotosModel> list){
        this.list = list;
        notifyDataSetChanged();

}

    public class VH  extends   RecyclerView.ViewHolder{
        ItemCompetitionPhotosBinding binding ;
        public VH(@NonNull ItemCompetitionPhotosBinding itemView) {
            super(itemView.getRoot());
            this.binding =itemView;
        }
    }




}
