package com.example.judo.ui.news;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.judo.model.news_item.NewsItemModel;
import com.example.judo.repository.RepositoryNews;

import java.util.List;

public class NewsViewModel extends ViewModel {


   private RepositoryNews repositoryNews = RepositoryNews.getInstance();


    public MutableLiveData<List<NewsItemModel>> getNews(FragmentActivity activity){

        return repositoryNews.getNews(activity);

    }
}
