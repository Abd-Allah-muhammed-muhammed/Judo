package com.example.judo.ui.news_details;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.judo.BuildConfig;
import com.example.judo.R;
import com.example.judo.databinding.FragmentNewsDetailsBinding;
import com.example.judo.databinding.NewsFragmentBinding;

import static com.example.judo.helper.HelperMethods.fullScreen;

public class NewsDetailsFragment extends Fragment implements View.OnClickListener {

    FragmentNewsDetailsBinding binding ;

    String test = "https://wallpaperaccess.com/full/124582.jpg";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_news_details, container, false);
        Glide.with(getContext()).load(test).into( binding.imgDetails);

        binding.backDetails.setOnClickListener(this);
        binding.share.setOnClickListener(this);
        return binding.getRoot();



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.back_details:
                getActivity().onBackPressed();
                break;

            case R.id.share:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        "test");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
        }
    }
}
