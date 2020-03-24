package com.example.judo.ui.competitions;

import android.app.Activity;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.judo.R;
import com.example.judo.model.copmetitions.CompetitionModel;

import java.util.ArrayList;
import java.util.List;

public class ComptitionsViewModel extends ViewModel {

    MutableLiveData<List<CompetitionModel>> data = new MutableLiveData<>();
    public MutableLiveData<List<CompetitionModel>> getData(Activity activity) {


        List<CompetitionModel> competitionModels = new ArrayList<>();

        competitionModels.add(new CompetitionModel("https://wallpaperaccess.com/full/124582.jpg",activity.getString(R.string.test_titel_comp),"12 ابريل 2020",true));
        competitionModels.add(new CompetitionModel("https://wallpaperaccess.com/full/124582.jpg",activity.getString(R.string.test_titel_comp),"12 ابريل 2020",true));
        competitionModels.add(new CompetitionModel("https://wallpaperaccess.com/full/124582.jpg",activity.getString(R.string.test_titel_comp),"12 ابريل 2020",false));
        competitionModels.add(new CompetitionModel("https://wallpaperaccess.com/full/124582.jpg",activity.getString(R.string.test_titel_comp),"12 ابريل 2020",true));
        competitionModels.add(new CompetitionModel("https://wallpaperaccess.com/full/124582.jpg",activity.getString(R.string.test_titel_comp),"12 ابريل 2020",false));
        competitionModels.add(new CompetitionModel("https://wallpaperaccess.com/full/124582.jpg",activity.getString(R.string.test_titel_comp),"12 ابريل 2020",true));
        competitionModels.add(new CompetitionModel("https://wallpaperaccess.com/full/124582.jpg",activity.getString(R.string.test_titel_comp),"12 ابريل 2020",true));
        competitionModels.add(new CompetitionModel("https://wallpaperaccess.com/full/124582.jpg",activity.getString(R.string.test_titel_comp),"12 ابريل 2020",false));
        competitionModels.add(new CompetitionModel("https://wallpaperaccess.com/full/124582.jpg",activity.getString(R.string.test_titel_comp),"12 ابريل 2020",true));


        data.setValue(competitionModels);

        return data;

    }

}
