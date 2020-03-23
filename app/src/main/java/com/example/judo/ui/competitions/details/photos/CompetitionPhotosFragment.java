package com.example.judo.ui.competitions.details.photos;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.judo.R;
import com.example.judo.adapters.PhotosAdapter;
import com.example.judo.databinding.CompetitionPhotosFragmentBinding;
import com.example.judo.model.photos.PhotosModel;

import java.util.List;

public class CompetitionPhotosFragment extends Fragment {

    private CompetitionPhotosViewModel mViewModel;

    private CompetitionPhotosFragmentBinding binding;
    private PhotosAdapter adapter ;

    public static CompetitionPhotosFragment newInstance() {
        return new CompetitionPhotosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding  = DataBindingUtil.inflate(inflater,R.layout.competition_photos_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(CompetitionPhotosViewModel.class);
        mViewModel.getData().observe(getViewLifecycleOwner(), new Observer<List<PhotosModel>>() {
            @Override
            public void onChanged(List<PhotosModel> photosModels) {
                adapter = new PhotosAdapter(getActivity());
                binding.rvImage.setLayoutManager(new GridLayoutManager(getContext(),3));
                binding.rvImage.setAdapter(adapter);
                adapter.setPhotos(photosModels);
            }
        });
    }

}
