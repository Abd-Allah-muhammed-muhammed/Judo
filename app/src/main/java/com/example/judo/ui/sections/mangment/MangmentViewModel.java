package com.example.judo.ui.sections.mangment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.judo.R;
import com.example.judo.model.sections.SectionModel;

import java.util.ArrayList;
import java.util.List;

public class MangmentViewModel extends ViewModel {

    MutableLiveData<List<SectionModel>> data = new MutableLiveData<>();

    public MutableLiveData<List<SectionModel>> getData(){

        List<SectionModel> sectionModels = new ArrayList<>();
        sectionModels.add(new SectionModel("كابتن محمد احمد ","مدرب السعوديه للجودو", R.drawable.photo_1));
        sectionModels.add(new SectionModel("كابتن محمد احمد ","مدرب السعوديه للجودو", R.drawable.photo_1));
        sectionModels.add(new SectionModel("كابتن محمد احمد ","مدرب السعوديه للجودو", R.drawable.photo_1));
        sectionModels.add(new SectionModel("كابتن محمد احمد ","مدرب السعوديه للجودو", R.drawable.photo_1));
        sectionModels.add(new SectionModel("كابتن محمد احمد ","مدرب السعوديه للجودو", R.drawable.photo_1));
        sectionModels.add(new SectionModel("كابتن محمد احمد ","مدرب السعوديه للجودو", R.drawable.photo_1));
        sectionModels.add(new SectionModel("كابتن محمد احمد ","مدرب السعوديه للجودو", R.drawable.photo_1));
        sectionModels.add(new SectionModel("كابتن محمد احمد ","مدرب السعوديه للجودو", R.drawable.photo_1));
        data.setValue(sectionModels);


        return data;
    }
}
