package com.example.judo.ui.more;

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
import com.example.judo.databinding.MoreFragmentBinding;
import com.example.judo.ui.language.LanguageFragment;

import static com.example.judo.helper.HelperMethods.replace;

public class MoreFragment extends Fragment implements View.OnClickListener {

    private MoreViewModel mViewModel;
    private MoreFragmentBinding binding;

    public static MoreFragment newInstance() {
        return new MoreFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.more_fragment, container, false);
        binding.layoutLanguge.setOnClickListener(this);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MoreViewModel.class);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_languge:
                openLanguageFragment();
                break;
        }
    }

    private void openLanguageFragment() {

        replace(new LanguageFragment(),R.id.hom_container,getFragmentManager().beginTransaction(),"language");

    }
}
