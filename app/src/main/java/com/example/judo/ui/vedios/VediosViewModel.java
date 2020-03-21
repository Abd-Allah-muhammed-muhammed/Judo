package com.example.judo.ui.vedios;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.judo.model.videos.VideosModel;

import java.util.ArrayList;
import java.util.List;

public class VediosViewModel extends ViewModel {

    MutableLiveData<List<VideosModel>> data = new MutableLiveData<>();

    public MutableLiveData<List<VideosModel>> getData() {

        List<VideosModel> videosModels = new ArrayList<>();
        videosModels.add(new VideosModel("https://wallpaperaccess.com/full/124582.jpg",
                "بطولة المملكة للاندية والهئيات والجامعات للدرجة الأولى بمكة و المفاجأة سعفان", "20 20 2020", "12:00  دقيقة"
                , "http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"));
        videosModels.add(new VideosModel("https://wallpaperaccess.com/full/124582.jpg",
                "بطولة المملكة للاندية والهئيات والجامعات للدرجة الأولى بمكة و المفاجأة سعفان", "20 20 2020", "12:00  دقيقة"
                , "http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"));
        videosModels.add(new VideosModel("https://wallpaperaccess.com/full/124582.jpg",
                "بطولة المملكة للاندية والهئيات والجامعات للدرجة الأولى بمكة و المفاجأة سعفان", "20 20 2020", "12:00  دقيقة"
                , "http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"));
        videosModels.add(new VideosModel("https://wallpaperaccess.com/full/124582.jpg",
                "بطولة المملكة للاندية والهئيات والجامعات للدرجة الأولى بمكة و المفاجأة سعفان", "20 20 2020", "12:00  دقيقة"
                , "http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"));
        videosModels.add(new VideosModel("https://wallpaperaccess.com/full/124582.jpg",
                "بطولة المملكة للاندية والهئيات والجامعات للدرجة الأولى بمكة و المفاجأة سعفان", "20 20 2020", "12:00  دقيقة"
                , "http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"));
        videosModels.add(new VideosModel("https://wallpaperaccess.com/full/124582.jpg",
                "بطولة المملكة للاندية والهئيات والجامعات للدرجة الأولى بمكة و المفاجأة سعفان", "20 20 2020", "12:00  دقيقة"
                , "http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"));
        videosModels.add(new VideosModel("https://wallpaperaccess.com/full/124582.jpg",
                "بطولة المملكة للاندية والهئيات والجامعات للدرجة الأولى بمكة و المفاجأة سعفان", "20 20 2020", "12:00  دقيقة"
                , "http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"));

        data.setValue(videosModels);

        return data;
    }
}
