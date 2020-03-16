package com.example.judo.ui.news;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.judo.R;

import static com.example.judo.helper.HelperMethods.replace;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        replace(new NewsFragment(),R.id.news_container,getSupportFragmentManager().beginTransaction(),"news");

    }
}
