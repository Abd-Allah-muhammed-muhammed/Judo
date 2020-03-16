package com.example.judo.ui.hom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.graphics.Color;
import android.os.Bundle;
import com.example.judo.R;
import com.example.judo.adapters.HomeSliderAdapter;
import com.example.judo.databinding.ActivityHomBinding;
import com.example.judo.model.SliderModelHome;

import java.util.ArrayList;
import java.util.List;

public class HomActivity extends AppCompatActivity {

    ActivityHomBinding binding ;

    private HomeSliderAdapter sliderAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_hom);
        binding.setLifecycleOwner(this);
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
}
