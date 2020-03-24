package com.example.judo.ui.courses;

import android.app.Activity;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.judo.R;
import com.example.judo.model.courses.CoursesModel;

import java.util.ArrayList;
import java.util.List;

public class CoursesViewModel extends ViewModel {


    MutableLiveData<List<CoursesModel>> data = new MutableLiveData<>();

    public  MutableLiveData<List<CoursesModel>> getData(Activity activity){

        List<CoursesModel> coursesModels = new ArrayList<>();
        coursesModels.add(new CoursesModel("https://wallpaperaccess.com/full/124582.jpg",

                 activity.getString(R.string.test_titel_course)
                 ,
                "2020 ابريل 12"
                ));
                coursesModels.add(new CoursesModel("https://wallpaperaccess.com/full/124582.jpg",

                 activity.getString(R.string.test_titel_course)
                 ,
                "2020 ابريل 12"
                ));
                coursesModels.add(new CoursesModel("https://wallpaperaccess.com/full/124582.jpg",

                 activity.getString(R.string.test_titel_course)
                 ,
                "2020 ابريل 12"
                ));
                coursesModels.add(new CoursesModel("https://wallpaperaccess.com/full/124582.jpg",

                 activity.getString(R.string.test_titel_course)
                 ,
                "2020 ابريل 12"
                ));
                coursesModels.add(new CoursesModel("https://wallpaperaccess.com/full/124582.jpg",

                 activity.getString(R.string.test_titel_course)
                 ,
                "2020 ابريل 12"
                ));
                coursesModels.add(new CoursesModel("https://wallpaperaccess.com/full/124582.jpg",

                 activity.getString(R.string.test_titel_course)
                 ,
                "2020 ابريل 12"
                ));
                coursesModels.add(new CoursesModel("https://wallpaperaccess.com/full/124582.jpg",

                 activity.getString(R.string.test_titel_course)
                 ,
                "2020 ابريل 12"
                ));


        data.setValue(coursesModels);


        return data;
    }
}
