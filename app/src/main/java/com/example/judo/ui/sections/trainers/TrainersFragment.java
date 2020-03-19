package com.example.judo.ui.sections.trainers;

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
import com.example.judo.adapters.SectionAdapter;
import com.example.judo.databinding.TrainersFragmentBinding;
import com.example.judo.model.sections.SectionModel;

import java.util.List;

public class TrainersFragment extends Fragment {

    private TrainersViewModel mViewModel;
    private SectionAdapter adapter;

    private TrainersFragmentBinding binding;
    public static TrainersFragment newInstance() {
        return new TrainersFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.trainers_fragment, container, false);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.backTrainers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TrainersViewModel.class);
        mViewModel.getData().observe(getViewLifecycleOwner(), new Observer<List<SectionModel>>() {
            @Override
            public void onChanged(List<SectionModel> sectionModels) {
                adapter = new SectionAdapter();
                binding.rvTrainers.setLayoutManager(new LinearLayoutManager(getContext()));
                binding.rvTrainers.setAdapter(adapter);
                adapter.setSectionModels(sectionModels);
            }
        });
    }

}
