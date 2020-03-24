package com.example.judo.ui.sections;

import android.app.Activity;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.judo.R;
import com.example.judo.model.about_model.AboutUsModel;
import com.example.judo.model.sections.SectionsInputModel;

import java.util.ArrayList;
import java.util.List;

public class SectionsViewModel extends ViewModel {


    public MutableLiveData<List<SectionsInputModel>> getDataSections(Activity activity){


        MutableLiveData<List<SectionsInputModel>> data = new MutableLiveData<>();

        List<SectionsInputModel>  sectionsInputModels = new ArrayList<>();

        sectionsInputModels.add(new SectionsInputModel(R.drawable.setting,activity.getString(R.string.mangment)));
        sectionsInputModels.add(new SectionsInputModel(R.drawable.men,activity.getString(R.string.players)));
        sectionsInputModels.add(new SectionsInputModel(R.drawable.manger,activity.getString(R.string.trainers)));
        sectionsInputModels.add(new SectionsInputModel(R.drawable.men,activity.getString(R.string.referee)));

        data.setValue(sectionsInputModels);

        return data;
    }
}
