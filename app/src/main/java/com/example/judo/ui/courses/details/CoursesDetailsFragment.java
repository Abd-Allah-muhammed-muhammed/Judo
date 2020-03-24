package com.example.judo.ui.courses.details;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.judo.R;
import com.example.judo.databinding.CoursesDetailsFragmentBinding;

import static com.example.judo.helper.HelperMethods.isEnglish;

public class CoursesDetailsFragment extends Fragment {

    private CoursesDetailsViewModel mViewModel;
    private CoursesDetailsFragmentBinding binding ;

    public static CoursesDetailsFragment newInstance() {
        return new CoursesDetailsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.courses_details_fragment, container, false);
        if (isEnglish()){

            binding.backDetails.setImageResource(R.drawable.ic_right_white);
        }
        binding.backDetails.setOnClickListener(new View.OnClickListener() {
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
        mViewModel = ViewModelProviders.of(this).get(CoursesDetailsViewModel.class);

    }

}
