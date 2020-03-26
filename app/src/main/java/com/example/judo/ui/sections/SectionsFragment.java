package com.example.judo.ui.sections;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.database.DatabaseUtils;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.judo.R;
import com.example.judo.adapters.SectionsAdapter;
import com.example.judo.databinding.SectionsFragmentBinding;
import com.example.judo.model.sections.SectionsInputModel;

import java.util.List;

import static com.example.judo.helper.HelperMethods.isEnglish;

public class SectionsFragment extends Fragment {

    private SectionsViewModel mViewModel;
    private SectionsAdapter adapter ;
    private SectionsFragmentBinding binding ;

    public static SectionsFragment newInstance() {
        return new SectionsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.sections_fragment, container, false);

        if (isEnglish(getActivity())){

            binding.backSections.setImageResource(R.drawable.ic_right_white);
        }

        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.backSections.setOnClickListener(new View.OnClickListener() {
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
        mViewModel = ViewModelProviders.of(this).get(SectionsViewModel.class);
        binding.setLifecycleOwner(this);
        mViewModel.getDataSections(getActivity()).observe(getViewLifecycleOwner(), new Observer<List<SectionsInputModel>>() {
            @Override
            public void onChanged(List<SectionsInputModel> sectionsInputModels) {
                adapter = new SectionsAdapter();
                binding.rvSections.setLayoutManager(new LinearLayoutManager(getContext()));
                binding.rvSections.setAdapter(adapter);
                adapter.setSectionsInputModels(sectionsInputModels);
            }
        });


    }

}
