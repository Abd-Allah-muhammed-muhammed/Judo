package com.example.judo.model.videos;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

public class VideosModel {

    String image ;
    String title ;
    String date ;
    String videoDuration;
    String video ;

    public VideosModel(String image, String title, String date, String videoDuration , String video) {
        this.image = image;
        this.title = title;
        this.date = date;
        this.videoDuration = videoDuration;
        this.video = video;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVideoDuration() {
        return videoDuration;
    }

    public void setVideoDuration(String videoDuration) {
        this.videoDuration = videoDuration;
    }


    @BindingAdapter({"android:src"})
    public static void setImageViewResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }

}
