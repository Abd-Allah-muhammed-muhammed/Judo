package com.example.judo.ui.about_us.union_goals;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.judo.R;
import com.example.judo.databinding.FragmentUnionGoalsBinding;

import static com.example.judo.helper.HelperMethods.isEnglish;

/**
 * A simple {@link Fragment} subclass.
 */
public class UnionGoalsFragment extends Fragment {

    private FragmentUnionGoalsBinding binding ;
    public UnionGoalsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_union_goals, container, false);
        if (isEnglish()){

            binding.backGoals.setImageResource(R.drawable.ic_right_black);
        }
        binding.backGoals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().onBackPressed();
            }
        });
        return binding.getRoot();
    }
}
