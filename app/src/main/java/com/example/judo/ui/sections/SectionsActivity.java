package com.example.judo.ui.sections;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.judo.R;

import static com.example.judo.helper.HelperMethods.replace;

public class SectionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sections);
        replace(new SectionsFragment(),R.id.sections_container,getSupportFragmentManager().beginTransaction());
    }
}
