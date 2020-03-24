package com.example.judo.ui.courses;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.judo.R;
import com.example.judo.adapters.CoursesAdapter;
import com.example.judo.databinding.CoursesFragmentBinding;
import com.example.judo.model.courses.CoursesModel;
import com.example.judo.ui.hom.HomActivity;

import java.util.List;

import static com.example.judo.helper.HelperMethods.isEnglish;

public class CoursesFragment extends Fragment {

    private CoursesViewModel mViewModel;
    private CoursesAdapter adapter ;
    private CoursesFragmentBinding binding;

    public static CoursesFragment newInstance() {
        return new CoursesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.courses_fragment, container, false);

        if (isEnglish()){

            binding.backCourses.setImageResource(R.drawable.ic_right_white);
        }
        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.backCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToHom();
            }
        });
        return binding.getRoot();
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(CoursesViewModel.class);

        mViewModel.getData(getActivity()).observe(getViewLifecycleOwner(), new Observer<List<CoursesModel>>() {
            @Override
            public void onChanged(List<CoursesModel> coursesModels) {
                adapter = new CoursesAdapter(getActivity());
                binding.rvCourses.setLayoutManager(new LinearLayoutManager(getContext()));
                binding.rvCourses.setAdapter(adapter);
                adapter.setCourses(coursesModels);
            }
        });
    }
    private void backToHom() {

        getActivity().onBackPressed();
    }
}
