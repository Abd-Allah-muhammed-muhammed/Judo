package com.example.judo.ui.news;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.judo.R;
import com.example.judo.adapters.NewsAdapter;
import com.example.judo.databinding.NewsFragmentBinding;
import com.example.judo.model.news_item.NewsItemModel;

import java.util.List;

public class NewsFragment extends Fragment implements View.OnClickListener {

    private NewsViewModel mViewModel;
    private NewsFragmentBinding binding ;

    private NewsAdapter newsAdapter ;
    public static NewsFragment newInstance() {
        return new NewsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.news_fragment, container, false);
        newsAdapter = new NewsAdapter(getActivity());
        binding.rvNews.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvNews.setAdapter(newsAdapter);
        binding.back.setOnClickListener(this);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        mViewModel.getNews().observe(getViewLifecycleOwner(), new Observer<List<NewsItemModel>>() {
            @Override
            public void onChanged(List<NewsItemModel> newsItemModels) {

                newsAdapter.setNews(newsItemModels);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                getActivity().onBackPressed();
                break;
        }
    }
}
