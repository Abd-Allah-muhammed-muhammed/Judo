package com.example.judo.ui.competitions.details.mangment;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.judo.R;

public class MangmentCompetitionFragment extends Fragment {

    private MangmentCompetitionViewModel mViewModel;

    public static MangmentCompetitionFragment newInstance() {
        return new MangmentCompetitionFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mangment_competition_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MangmentCompetitionViewModel.class);
        // TODO: Use the ViewModel
    }

}
