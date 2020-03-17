package com.example.judo.ui.about_us;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.judo.R;
import com.example.judo.ui.about_us.ui.aboutus.AboutUsFragment;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_about_us, AboutUsFragment.newInstance())
                    .commitNow();
        }
    }
}
