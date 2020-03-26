package com.example.judo.ui.sections.players;

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
import com.example.judo.adapters.FilterPlayersAdapter;
import com.example.judo.adapters.SectionAdapter;
import com.example.judo.databinding.PlayersFragmentBinding;
import com.example.judo.model.sections.SectionModel;

import java.util.List;

import static com.example.judo.helper.HelperMethods.isEnglish;

public class PlayersFragment extends Fragment {

    private PlayersViewModel mViewModel;
    private SectionAdapter adapter ;
    private PlayersFragmentBinding binding ;
    private FilterPlayersAdapter filterPlayersAdapter ;

    public static PlayersFragment newInstance() {
        return new PlayersFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.players_fragment,container,false);

        if (isEnglish(getActivity())){

            binding.backPlayers.setImageResource(R.drawable.ic_right_white);
        }

        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.backPlayers.setOnClickListener(new View.OnClickListener() {
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
        mViewModel = ViewModelProviders.of(this).get(PlayersViewModel.class);
        mViewModel.getDataPlayers().observe(getViewLifecycleOwner(), new Observer<List<SectionModel>>() {
            @Override
            public void onChanged(List<SectionModel> sectionModels) {
                adapter = new SectionAdapter();
                binding.rvPlayers.setLayoutManager(new LinearLayoutManager(getContext()));
                binding.rvPlayers.setAdapter(adapter);
                adapter.setSectionModels(sectionModels);
            }
        });


        mViewModel.getDataFilter().observe(getViewLifecycleOwner(), new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                filterPlayersAdapter = new FilterPlayersAdapter();
                binding.rvFilter.setAdapter(filterPlayersAdapter);
                binding.rvFilter.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));
                filterPlayersAdapter.setFilters(strings);

            }
        });
    }

}
