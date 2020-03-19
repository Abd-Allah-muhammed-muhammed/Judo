package com.example.judo.model.sections;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

public class SectionModel {

    String name ;
    String type ;
    int image;


    public SectionModel(String name, String type, int image) {
        this.name = name;
        this.type = type;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }



    @BindingAdapter({"android:src"})
    public static void setImageViewResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }
}
