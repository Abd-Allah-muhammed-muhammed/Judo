package com.example.judo.ui.competitions.details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.judo.R;
import com.example.judo.adapters.TapLayoutAdapter;
import com.example.judo.databinding.ActivityCompetitionDetailsBinding;
import com.google.android.material.tabs.TabLayout;

public class CompetitionDetailsActivity extends AppCompatActivity {

    private ActivityCompetitionDetailsBinding binding ;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_competition_details);




        binding.viewPager.setAdapter(new TapLayoutAdapter(getSupportFragmentManager()));
        binding.tabCompetitions.setupWithViewPager(binding.viewPager);
        binding.backCompDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });

//
//        for (int i = 0; i < binding.tabCompetitions.getTabCount(); i++) {
//            //noinspection ConstantConditions
//            TextView tv = (TextView) LayoutInflater.from(this).inflate(R.layout.text_tabs,null);
//            binding.tabCompetitions.getTabAt(i).setCustomView(tv);
//        }

    }



}
