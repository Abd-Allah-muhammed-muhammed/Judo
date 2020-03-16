package com.example.judo.model;

public class SliderModelHome {

    String image ;
    String title ;


    public SliderModelHome(String image, String title) {
        this.image = image;
        this.title = title;
    }

    public SliderModelHome() {
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
}
