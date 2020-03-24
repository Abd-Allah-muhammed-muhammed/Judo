package com.example.judo.ui.competitions;

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
import com.example.judo.adapters.CompetitionsAdapter;
import com.example.judo.databinding.ComptitionsFragmentBinding;
import com.example.judo.model.copmetitions.CompetitionModel;

import java.util.List;

public class CompetitionsFragment extends Fragment {

    private ComptitionsViewModel mViewModel;
    private ComptitionsFragmentBinding binding ;
    private CompetitionsAdapter adapter ;

    public static CompetitionsFragment newInstance() {
        return new CompetitionsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.comptitions_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ComptitionsViewModel.class);
        mViewModel.getData(getActivity()).observe(getViewLifecycleOwner(), new Observer<List<CompetitionModel>>() {
            @Override
            public void onChanged(List<CompetitionModel> competitionModels) {

                adapter = new CompetitionsAdapter(getActivity());
                binding.rvCompetitions.setLayoutManager(new LinearLayoutManager(getContext()));
                binding.rvCompetitions.setAdapter(adapter);
                adapter.setCompetitions(competitionModels);

            }
        });

    }

}
