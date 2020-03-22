package com.example.judo.ui.competitions.details.rank;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.judo.R;

public class CompetitionRanksFragment extends Fragment {

    private CompetitionRanksViewModel mViewModel;

    public static CompetitionRanksFragment newInstance() {
        return new CompetitionRanksFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.competition_ranks_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(CompetitionRanksViewModel.class);
        // TODO: Use the ViewModel
    }

}
