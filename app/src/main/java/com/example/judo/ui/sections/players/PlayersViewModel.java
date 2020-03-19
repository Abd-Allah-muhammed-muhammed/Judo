package com.example.judo.ui.sections.players;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.judo.R;
import com.example.judo.model.sections.SectionModel;

import java.util.ArrayList;
import java.util.List;

public class PlayersViewModel extends ViewModel {

    MutableLiveData<List<SectionModel>> data = new MutableLiveData<>();
    MutableLiveData<List<String>> dataFilter = new MutableLiveData<>();

    public MutableLiveData<List<SectionModel>> getDataPlayers(){

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


    public MutableLiveData<List<String>> getDataFilter(){

        List<String> listFilter =  new ArrayList<>();

        listFilter.add("الكل");
        listFilter.add("لاعبين المنتخب");
        listFilter.add("لاعبين الاندية");
        listFilter.add("لاعبين جدد");
        listFilter.add("لاعبين الاحطياط");

        dataFilter.setValue(listFilter);
        return dataFilter;
    }




}
