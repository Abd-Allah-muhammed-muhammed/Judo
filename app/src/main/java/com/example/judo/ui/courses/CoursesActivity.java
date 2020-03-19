package com.example.judo.ui.courses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.judo.R;

public class CoursesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.courses_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_courses, CoursesFragment.newInstance())
                    .commitNow();
        }
    }
}
