package com.example.judo.ui.about_us.know_union;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.judo.R;
import com.example.judo.databinding.KnowUnionFragmentBinding;

import java.util.Locale;

import static com.example.judo.helper.HelperMethods.isEnglish;

public class KnowUnionFragment extends Fragment {

    private KnowUnionViewModel mViewModel;
    private KnowUnionFragmentBinding binding;

    public static KnowUnionFragment newInstance() {
        return new KnowUnionFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.know_union_fragment, container, false);
        binding.backAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });


        if (isEnglish()){

            binding.backAbout.setImageResource(R.drawable.ic_right_black);

        }
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(KnowUnionViewModel.class);

    }

}
