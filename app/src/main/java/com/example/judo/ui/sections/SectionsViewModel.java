package com.example.judo.ui.sections;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.judo.R;
import com.example.judo.model.about_model.AboutUsModel;
import com.example.judo.model.sections.SectionsInputModel;

import java.util.ArrayList;
import java.util.List;

public class SectionsViewModel extends ViewModel {


    public MutableLiveData<List<SectionsInputModel>> getDataSections(){


        MutableLiveData<List<SectionsInputModel>> data = new MutableLiveData<>();

        List<SectionsInputModel>  sectionsInputModels = new ArrayList<>();

        sectionsInputModels.add(new SectionsInputModel(R.drawable.setting,"اداريين"));
        sectionsInputModels.add(new SectionsInputModel(R.drawable.men,"لاعبين"));
        sectionsInputModels.add(new SectionsInputModel(R.drawable.manger,"مدربين"));
        sectionsInputModels.add(new SectionsInputModel(R.drawable.men,"حكام"));

        data.setValue(sectionsInputModels);

        return data;
    }
}
