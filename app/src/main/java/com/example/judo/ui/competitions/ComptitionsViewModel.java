package com.example.judo.ui.competitions;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.judo.model.copmetitions.CompetitionModel;

import java.util.ArrayList;
import java.util.List;

public class ComptitionsViewModel extends ViewModel {

    MutableLiveData<List<CompetitionModel>> data = new MutableLiveData<>();
    public MutableLiveData<List<CompetitionModel>> getData() {


        List<CompetitionModel> competitionModels = new ArrayList<>();

        competitionModels.add(new CompetitionModel("https://wallpaperaccess.com/full/124582.jpg","بطولة النخبة التعليمية الثالثه عشر","12 ابريل 2020",true));
        competitionModels.add(new CompetitionModel("https://wallpaperaccess.com/full/124582.jpg","بطولة النخبة التعليمية الثالثه عشر","12 ابريل 2020",true));
        competitionModels.add(new CompetitionModel("https://wallpaperaccess.com/full/124582.jpg","بطولة النخبة التعليمية الثالثه عشر","12 ابريل 2020",true));
        competitionModels.add(new CompetitionModel("https://wallpaperaccess.com/full/124582.jpg","بطولة النخبة التعليمية الثالثه عشر","12 ابريل 2020",false));
        competitionModels.add(new CompetitionModel("https://wallpaperaccess.com/full/124582.jpg","بطولة النخبة التعليمية الثالثه عشر","12 ابريل 2020",true));
        competitionModels.add(new CompetitionModel("https://wallpaperaccess.com/full/124582.jpg","بطولة النخبة التعليمية الثالثه عشر","12 ابريل 2020",false));
        competitionModels.add(new CompetitionModel("https://wallpaperaccess.com/full/124582.jpg","بطولة النخبة التعليمية الثالثه عشر","12 ابريل 2020",true));
        competitionModels.add(new CompetitionModel("https://wallpaperaccess.com/full/124582.jpg","بطولة النخبة التعليمية الثالثه عشر","12 ابريل 2020",false));

        data.setValue(competitionModels);

        return data;

    }

}
