package com.example.judo.ui.about_us.union_message;

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
import com.example.judo.databinding.UnionMessageFragmentBinding;

import static com.example.judo.helper.HelperMethods.isEnglish;

public class UnionMessageFragment extends Fragment {

    private UnionMessageViewModel mViewModel;
    private UnionMessageFragmentBinding binding ;

    public static UnionMessageFragment newInstance() {
        return new UnionMessageFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.union_message_fragment, container, false);
        if (isEnglish(getActivity())){


            binding.backAbout.setImageResource(R.drawable.ic_right_black);
        }
        binding.backAbout.setOnClickListener(new View.OnClickListener() {
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
        mViewModel = ViewModelProviders.of(this).get(UnionMessageViewModel.class);

    }

}
