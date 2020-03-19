package com.example.judo.ui.about_us.ui.aboutus;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.judo.R;
import com.example.judo.model.about_model.AboutUsModel;

import java.util.ArrayList;
import java.util.List;

public class AboutUsViewModel extends ViewModel {


    public MutableLiveData<List<AboutUsModel>> getDataAbout(){


        MutableLiveData<List<AboutUsModel>> data = new MutableLiveData<>();

        List<AboutUsModel> aboutUsModels = new ArrayList<>();

        aboutUsModels.add(new AboutUsModel(R.drawable.logo_round,"تعرف على الاتحاد"));
        aboutUsModels.add(new AboutUsModel(R.drawable.msg,"رسالة الاتحاد"));
        aboutUsModels.add(new AboutUsModel(R.drawable.target,"تأهداف الاتحاد"));
        aboutUsModels.add(new AboutUsModel(R.drawable.founders,"مؤسسين الاتحاد"));

        data.setValue(aboutUsModels);

        return data;
    }

}
