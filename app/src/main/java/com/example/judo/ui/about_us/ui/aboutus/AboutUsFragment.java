package com.example.judo.ui.about_us.ui.aboutus;

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
import com.example.judo.adapters.AboutUsAdapter;
import com.example.judo.databinding.AboutUsFragmentBinding;
import com.example.judo.model.about_model.AboutUsModel;

import java.util.List;

import static com.example.judo.helper.HelperMethods.isEnglish;

public class AboutUsFragment extends Fragment implements View.OnClickListener {

    private AboutUsViewModel mViewModel;
    private AboutUsFragmentBinding binding ;
    private AboutUsAdapter adapter ;

    public static AboutUsFragment newInstance() {
        return new AboutUsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.about_us_fragment, container, false);
        binding.backAbout.setOnClickListener(this);

        if (isEnglish(getActivity())){


            binding.backAbout.setImageResource(R.drawable.ic_right_white);
        }

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AboutUsViewModel.class);

       mViewModel.getDataAbout(getActivity()).observe(getViewLifecycleOwner(), new Observer<List<AboutUsModel>>() {
           @Override
           public void onChanged(List<AboutUsModel> aboutUsModels) {

               adapter = new AboutUsAdapter();
               binding.rvAboutUs.setLayoutManager(new LinearLayoutManager(getContext()));
               binding.rvAboutUs.setAdapter(adapter);

               if (!aboutUsModels.isEmpty()) {
                   adapter.setAboutUsModels(aboutUsModels);
               }
           }
       });




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.back_about:
                getActivity().onBackPressed();
        }
    }
}
