package com.example.judo.ui.about_us.ui.aboutus;

import android.app.Activity;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.judo.R;
import com.example.judo.model.about_model.AboutUsModel;

import java.util.ArrayList;
import java.util.List;

public class AboutUsViewModel extends ViewModel {


    public MutableLiveData<List<AboutUsModel>> getDataAbout(Activity activity){


        MutableLiveData<List<AboutUsModel>> data = new MutableLiveData<>();

        List<AboutUsModel> aboutUsModels = new ArrayList<>();

        aboutUsModels.add(new AboutUsModel(R.drawable.logo_round,activity.getString(R.string.know_union)));
        aboutUsModels.add(new AboutUsModel(R.drawable.msg,activity.getString(R.string.union_message)));
        aboutUsModels.add(new AboutUsModel(R.drawable.target,activity.getString(R.string.union_target)));
        aboutUsModels.add(new AboutUsModel(R.drawable.founders,activity.getString(R.string.union_founders)));

        data.setValue(aboutUsModels);

        return data;
    }

}
