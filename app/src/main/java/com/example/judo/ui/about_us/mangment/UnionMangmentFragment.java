package com.example.judo.ui.about_us.mangment;

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
import com.example.judo.databinding.UnionMangmentFragmentBinding;
import com.example.judo.model.sections.SectionModel;

import java.util.List;

public class UnionMangmentFragment extends Fragment {

    private UnionMangmentViewModel mViewModel;
    private UnionMangmentFragmentBinding binding ;
    private SectionAdapter adapter ;

    public static UnionMangmentFragment newInstance() {
        return new UnionMangmentFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.union_mangment_fragment,container,false);

        binding.backFounders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().onBackPressed();
            }
        });
        return  binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(UnionMangmentViewModel.class);
        mViewModel.getData().observe(getViewLifecycleOwner(), new Observer<List<SectionModel>>() {
            @Override
            public void onChanged(List<SectionModel> sectionModels) {
                adapter = new SectionAdapter();
                binding.rvFounders.setLayoutManager(new LinearLayoutManager(getContext()));
                binding.rvFounders.setAdapter(adapter);
                adapter.setSectionModels(sectionModels );

            }
        });

    }

}
