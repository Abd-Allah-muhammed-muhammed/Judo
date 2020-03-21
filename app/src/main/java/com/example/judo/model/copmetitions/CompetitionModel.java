package com.example.judo.model.copmetitions;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

public class CompetitionModel {

    String image ;
    String title;
    String date ;
    boolean isOfficial;

    public CompetitionModel(String image, String title, String date, boolean isOfficial) {
        this.image = image;
        this.title = title;
        this.date = date;
        this.isOfficial = isOfficial;
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

    public boolean isOfficial() {
        return isOfficial;
    }

    public void setOfficial(boolean official) {
        isOfficial = official;
    }

    @BindingAdapter({"android:src"})
    public static void setImageViewResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }

}
