package com.example.judo.ui.contect_us;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.Nullable;

import android.os.PersistableBundle;
import android.view.View;
import android.widget.Toast;

import com.example.judo.R;
import com.example.judo.databinding.ContectUsActivityBinding;

import static com.example.judo.helper.HelperMethods.isEnglish;

public class ContectUsActivity extends AppCompatActivity {

    private ContectUsViewModel mViewModel;

    private ContectUsActivityBinding binding ;

    public static ContectUsActivity newInstance() {
        return new ContectUsActivity();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.contect_us_activity);
        binding.backContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mViewModel = ViewModelProviders.of(this).get(ContectUsViewModel.class);

        if(isEnglish(this)){
            binding.backContactUs.setImageResource(R.drawable.ic_right_white);
        }

    }


}
