package com.example.judo.ui.vedios.play_video;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.media.session.MediaController;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.judo.R;
import com.example.judo.databinding.PlayVideoFragmentBinding;

import java.util.Objects;

import cn.jzvd.JZVideoPlayer;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;

public class PlayVideoFragment extends Fragment {

    private PlayVideoViewModel mViewModel;
    private PlayVideoFragmentBinding binding ;


    public static PlayVideoFragment newInstance() {
        return new PlayVideoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater ,R.layout.play_video_fragment, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();

        return binding.getRoot();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(PlayVideoViewModel.class);


        String video = getArguments().getString("video");
        binding.playVideo.setUp(video, JZVideoPlayer.SCROLL_AXIS_HORIZONTAL);
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }
    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
        binding.playVideo.release();
    }


}
