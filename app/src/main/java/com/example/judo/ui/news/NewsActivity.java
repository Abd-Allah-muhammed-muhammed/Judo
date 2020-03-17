package com.example.judo.ui.news;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.judo.R;

import com.example.judo.ui.news_details.NewsDetailsFragment;

import static com.example.judo.helper.HelperMethods.fullScreen;
import static com.example.judo.helper.HelperMethods.replace;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        int id = getIntent().getIntExtra("id", 0);

        if (id==1){

            replace(new NewsDetailsFragment(),R.id.news_container,getSupportFragmentManager().beginTransaction());

        }else {
            replace(new NewsFragment(),R.id.news_container,getSupportFragmentManager().beginTransaction());


        }


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
