package com.example.judo.ui.competitions.details.mangment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.judo.R;
import com.example.judo.model.sections.SectionModel;

import java.util.ArrayList;
import java.util.List;

public class MangmentCompetitionViewModel extends ViewModel {

    MutableLiveData<List<SectionModel>> data = new MutableLiveData<>();

    public MutableLiveData<List<SectionModel>> getData() {

        List<SectionModel> sectionModels = new ArrayList<>();

        sectionModels.add(new SectionModel("Ahmed", "coach", R.drawable.photo_1));
        sectionModels.add(new SectionModel("muhammed ahmed", "coach", R.drawable.photo_3));
        sectionModels.add(new SectionModel("ebrahem ahmed", "coach", R.drawable.pgoto_2));
        sectionModels.add(new SectionModel("mustafa alla ahmed", "coach", R.drawable.photo_1));
        sectionModels.add(new SectionModel("tamer ebrahem mustafa", "coach", R.drawable.pgoto_2));

        data.setValue(sectionModels);
        return data;
    }
}
