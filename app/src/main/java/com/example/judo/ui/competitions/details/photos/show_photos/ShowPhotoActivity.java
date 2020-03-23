package com.example.judo.ui.competitions.details.photos.show_photos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.judo.R;
import com.example.judo.databinding.ActivityShowPhotoBinding;

public class ShowPhotoActivity extends AppCompatActivity {

    private ActivityShowPhotoBinding binding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_show_photo);

        String photo_comp = getIntent().getStringExtra("imag_comp");

        Glide.with(getApplicationContext()).load(photo_comp).into(binding.showImage);

        binding.cancelPhotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });
    }
}
