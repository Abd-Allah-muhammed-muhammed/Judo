package com.example.judo.ui.competitions.details.mangment;

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
import com.example.judo.databinding.MangmentCompetitionFragmentBinding;
import com.example.judo.model.sections.SectionModel;

import java.util.List;

public class MangmentCompetitionFragment extends Fragment {

    private MangmentCompetitionViewModel mViewModel;
    SectionAdapter adapter;
    private MangmentCompetitionFragmentBinding binding ;
    public static MangmentCompetitionFragment newInstance() {
        return new MangmentCompetitionFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding= DataBindingUtil.inflate(inflater, R.layout.mangment_competition_fragment, container, false);
        return binding.getRoot();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MangmentCompetitionViewModel.class);
        mViewModel.getData().observe(getViewLifecycleOwner(), new Observer<List<SectionModel>>() {
            @Override
            public void onChanged(List<SectionModel> sectionModels) {
                adapter=new SectionAdapter();
                binding.organizersRv.setLayoutManager(new LinearLayoutManager(getContext()));
                binding.organizersRv.setAdapter(adapter);
                adapter.setSectionModels(sectionModels);


            }
        });
    }

}
