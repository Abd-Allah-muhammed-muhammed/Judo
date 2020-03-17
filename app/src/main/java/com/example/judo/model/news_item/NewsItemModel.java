package com.example.judo.model.news_item;

public class NewsItemModel {

    String image ;
    String titel ;
    String date ;

    public NewsItemModel() {
    }

    public NewsItemModel(String image, String titel, String date) {
        this.image = image;
        this.titel = titel;
        this.date = date;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
