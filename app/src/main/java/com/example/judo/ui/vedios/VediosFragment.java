package com.example.judo.ui.vedios;

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
import com.example.judo.adapters.VideosAdapter;
import com.example.judo.databinding.VediosFragmentBinding;
import com.example.judo.model.videos.VideosModel;

import java.util.List;

public class VediosFragment extends Fragment {

    private VediosViewModel mViewModel;
    private VediosFragmentBinding binding ;
    private VideosAdapter adapter ;

    public static VediosFragment newInstance() {
        return new VediosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.vedios_fragment, container, false);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(VediosViewModel.class);
        mViewModel.getData().observe(getViewLifecycleOwner(), new Observer<List<VideosModel>>() {
            @Override
            public void onChanged(List<VideosModel> videosModels) {

                adapter = new VideosAdapter(getActivity());
                binding.rvVideos.setLayoutManager(new LinearLayoutManager(getContext()));
                binding.rvVideos.setAdapter(adapter);
                adapter.setVideos(videosModels);
            }
        });
    }

}
