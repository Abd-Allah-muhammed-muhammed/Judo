package com.example.judo.ui.sections.mangment;

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
import com.example.judo.databinding.MangmentFragmentBinding;
import com.example.judo.model.sections.SectionModel;

import java.util.List;

public class MangmentFragment extends Fragment {

    private MangmentViewModel mViewModel;

    private MangmentFragmentBinding binding ;
    private SectionAdapter adapter ;
    public static MangmentFragment newInstance() {
        return new MangmentFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.mangment_fragment,container,false);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.backMangment.setOnClickListener(new View.OnClickListener() {
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
        mViewModel = ViewModelProviders.of(this).get(MangmentViewModel.class);
        mViewModel.getData().observe(getViewLifecycleOwner(), new Observer<List<SectionModel>>() {
            @Override
            public void onChanged(List<SectionModel> sectionModels) {
                adapter = new SectionAdapter();
                binding.rvMangment.setLayoutManager(new LinearLayoutManager(getContext()));
                binding.rvMangment.setAdapter(adapter);
                adapter.setSectionModels(sectionModels);

            }
        });

    }

}
