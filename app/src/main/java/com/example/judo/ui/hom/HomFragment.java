package com.example.judo.ui.hom;

import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.judo.R;
import com.example.judo.adapters.HomeSliderAdapter;
import com.example.judo.databinding.HomFragmentBinding;
import com.example.judo.model.SliderModelHome;
import com.example.judo.ui.about_us.AboutUsActivity;
import com.example.judo.ui.contect_us.ContectUsActivity;
import com.example.judo.ui.courses.CoursesActivity;
import com.example.judo.ui.news.NewsActivity;
import com.example.judo.ui.sections.SectionsActivity;

import java.util.ArrayList;
import java.util.List;

public class HomFragment extends Fragment implements View.OnClickListener {

    public static HomFragment newInstance() {
        return new HomFragment();
    }

    private HomViewModel mViewModel;
    private HomFragmentBinding binding ;
    private HomeSliderAdapter sliderAdapter ;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.hom_fragment, container, false);
        binding.moreTv.setOnClickListener(this);
        binding.layoutAboutUs.setOnClickListener(this);
        binding.layoutSections.setOnClickListener(this);
        binding.layoutCourses.setOnClickListener(this);
        binding.contactUsLayout.setOnClickListener(this);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HomViewModel.class);
        initSlider();
        getData();
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

            case R.id.layout_sections:
                openSections();
                break;

            case R.id.layout_courses:
                openCourses();
                break;

            case R.id.contact_us_layout :
                openContactUs();
                break;
        }
    }

    private void openContactUs() {

        startActivity(new Intent(getContext(), ContectUsActivity.class));

    }


    private void getData () {
            List<SliderModelHome> listSlider = new ArrayList<>();
            listSlider.add(new SliderModelHome("https://wallpaperaccess.com/full/124582.jpg"
                    , "بطولة المملكة للاندية والهئيات والجامعات للدرجة الأولى بمكة"));


            listSlider.add(new SliderModelHome("https://cdn.pixabay.com/photo/2017/11/13/23/33/landscape-2947094_960_720.jpg"
                    , "بطولة المملكة للاندية والهئيات والجامعات للدرجة الأولى بمكة"));

            listSlider.add(new SliderModelHome("https://www.robin-noorda.com/uploads/1/6/8/3/16830688/3347022_orig.jpg"
                    , "بطولة المملكة للاندية والهئيات والجامعات للدرجة الأولى بمكة"));

            sliderAdapter.setList(listSlider);


        }


    private void initSlider() {

        binding.viewPager.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));
        sliderAdapter = new HomeSliderAdapter(getActivity());
        binding.viewPager.setAdapter(sliderAdapter);


    }
        private void openCourses() {
            Intent intent = new Intent(getContext(), CoursesActivity.class);
            startActivity(intent);

        }

        private void openSections() {


            Intent intent = new Intent(getContext(), SectionsActivity.class);
            startActivity(intent);

        }

        private void openAboutUs() {

            Intent intent = new Intent(getContext(), AboutUsActivity.class);
            startActivity(intent);

        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        private void openNewsActivity() {

            Intent intent = new Intent(getContext(), NewsActivity.class);
            intent.putExtra("id",0);
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());


        }

}
