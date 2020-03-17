package com.example.judo.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.judo.model.news_item.NewsItemModel;

import java.util.ArrayList;
import java.util.List;

public class RepositoryNews {

    MutableLiveData<List<NewsItemModel>> data ;
    public static  RepositoryNews instance ;

    private RepositoryNews (){

        data = new MutableLiveData<>();
    }


public static  RepositoryNews getInstance(){


        if (instance==null){

instance = new RepositoryNews();
        }

        return instance;

}




public MutableLiveData<List<NewsItemModel>> getNews(){


        setStaticData();
        return  data ;


}

    private void setStaticData() {

        List< NewsItemModel> list = new ArrayList<>();
        list.add(new NewsItemModel("https://wallpaperaccess.com/full/124582.jpg","بطولة المملكة للاندية والهئيات والجامعات للدرجة الأولى بمكة و المفاجأة سعفان","12 فبراير 2020"));
        list.add(new NewsItemModel("https://cdn.pixabay.com/photo/2017/11/13/23/33/landscape-2947094_960_720.jpg","بطولة المملكة للاندية والهئيات والجامعات للدرجة الأولى بمكة و المفاجأة سعفان","12 فبراير 2020"));
        list.add(new NewsItemModel("https://www.robin-noorda.com/uploads/1/6/8/3/16830688/3347022_orig.jpg","بطولة المملكة للاندية والهئيات والجامعات للدرجة الأولى بمكة و المفاجأة سعفان","15 فبراير 2020"));
        data.setValue(list);

    }

}
