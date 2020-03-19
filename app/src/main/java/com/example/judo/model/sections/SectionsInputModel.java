package com.example.judo.model.sections;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

public class SectionsInputModel {

    int logo ;
    String title;


    public SectionsInputModel(int logo, String title) {
        this.logo = logo;
        this.title = title;
    }


    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    @BindingAdapter({"android:src"})
    public static void setImageViewResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }
}

