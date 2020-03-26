package com.example.judo.ui.sections.referee;

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
import com.example.judo.databinding.RefereeFragmentBinding;
import com.example.judo.model.sections.SectionModel;

import java.util.List;

import static com.example.judo.helper.HelperMethods.isEnglish;

public class RefereeFragment extends Fragment {

    private RefereeViewModel mViewModel;
    private SectionAdapter adapter ;
    private RefereeFragmentBinding binding ;

    public static RefereeFragment newInstance() {
        return new RefereeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.referee_fragment,container,false);

        if (isEnglish(getActivity())){

            binding.backReferee.setImageResource(R.drawable.ic_right_white);
        }

        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.backReferee.setOnClickListener(new View.OnClickListener() {
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
        mViewModel = ViewModelProviders.of(this).get(RefereeViewModel.class);
        mViewModel.getData().observe(getViewLifecycleOwner(), new Observer<List<SectionModel>>() {
            @Override
            public void onChanged(List<SectionModel> sectionModels) {
                adapter = new SectionAdapter();
                binding.rvReferee.setLayoutManager(new LinearLayoutManager(getContext()));
                binding.rvReferee.setAdapter(adapter);
                adapter.setSectionModels(sectionModels);
            }
        });

    }

}
