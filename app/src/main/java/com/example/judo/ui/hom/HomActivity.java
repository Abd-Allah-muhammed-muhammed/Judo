package com.example.judo.ui.hom;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.judo.R;
import com.example.judo.adapters.HomeSliderAdapter;
import com.example.judo.databinding.ActivityHomBinding;
import com.example.judo.model.SliderModelHome;
import com.example.judo.ui.about_us.AboutUsActivity;
import com.example.judo.ui.news.NewsActivity;

import java.util.ArrayList;
import java.util.List;

import static com.example.judo.helper.HelperMethods.fullScreen;

public class HomActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityHomBinding binding ;

    private HomeSliderAdapter sliderAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_hom);

        binding.setLifecycleOwner(this);
        binding.moreTv.setOnClickListener(this);
        binding.layoutAboutUs.setOnClickListener(this);
        initSlider();
        getData();

    }



    private void getData() {
        List<SliderModelHome> listSlider = new ArrayList<>();
        listSlider.add(new SliderModelHome("https://wallpaperaccess.com/full/124582.jpg"
                ,"بطولة المملكة للاندية والهئيات والجامعات للدرجة الأولى بمكة"));


        listSlider.add(new SliderModelHome("https://cdn.pixabay.com/photo/2017/11/13/23/33/landscape-2947094_960_720.jpg"
                ,"بطولة المملكة للاندية والهئيات والجامعات للدرجة الأولى بمكة"));

        listSlider.add(new SliderModelHome("https://www.robin-noorda.com/uploads/1/6/8/3/16830688/3347022_orig.jpg"
                ,"بطولة المملكة للاندية والهئيات والجامعات للدرجة الأولى بمكة"));

        sliderAdapter.setList(listSlider);


    }

    private void initSlider() {

        binding.viewPager.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
        sliderAdapter = new HomeSliderAdapter(HomActivity.this);
        binding.viewPager.setAdapter(sliderAdapter);


    }



    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    public void onStop()
    {
        super.onStop();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {

        int id = v.getId();
        switch (id) {

            case R.id.more_tv:
                openNewsActivity();
                break;

            case R.id.layout_about_us:

                openAboutUs();

                break;

        }


    }

    private void openAboutUs() {

        Intent intent = new Intent(HomActivity.this, AboutUsActivity.class);
        startActivity(intent);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void openNewsActivity() {

        Intent intent = new Intent(HomActivity.this, NewsActivity.class);
        intent.putExtra("id",0);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());


    }
}
