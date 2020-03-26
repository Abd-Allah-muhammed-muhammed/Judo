package com.example.judo.ui.splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import com.example.judo.R;
import com.example.judo.databinding.ActivitySplashBinding;
import com.example.judo.helper.PrefManager;
import com.example.judo.model.SliderModelHome;
import com.example.judo.ui.hom.HomActivity;

import java.util.Locale;

import static com.example.judo.helper.HelperMethods.fullScreen;

public class SplashActivity extends AppCompatActivity {
    Thread splashTread;
    ActivitySplashBinding binding ;
    private PrefManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fullScreen(this);


        manager = new PrefManager(this);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_splash);

        Locale locale = new Locale(manager.getLanguage());
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
       getResources().updateConfiguration(config,
                getResources().getDisplayMetrics());


        startSplash();
    }

    private void startSplash() {


        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 6000) {
                        sleep(50);
                        waited += 100;
                    }
                    Intent intent = new Intent(SplashActivity.this,
                            HomActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    SplashActivity.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    SplashActivity.this.finish();
                }

            }
        };
        splashTread.start();
    }



}



