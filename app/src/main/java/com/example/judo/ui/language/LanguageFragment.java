package com.example.judo.ui.language;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.judo.R;
import com.example.judo.databinding.FragmentLanguageBinding;
import com.example.judo.helper.PrefManager;
import com.example.judo.ui.more.MoreFragment;

import java.util.Locale;

import static com.example.judo.helper.HelperMethods.replace;

/**
 * A simple {@link Fragment} subclass.
 */
public class LanguageFragment extends Fragment implements View.OnClickListener {

    private FragmentLanguageBinding binding ;
    private PrefManager manager;
    private String language;

    public LanguageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_language,container,false);

//         check if the choose language is arabic or not
        manager = new PrefManager(getContext());
        String language = manager.getLanguage();
        if (language.equals("en")){

            binding.arabicLanguage.setTextColor(Color.GRAY);
            binding.englishLanguage.setTextColor(Color.WHITE);
            binding.arabicLanguage.setBackgroundResource(R.drawable.shape_english_rectangle);
            binding.englishLanguage.setBackgroundResource(R.drawable.shape_green_rectangle);

        }else {

            binding.englishLanguage.setBackgroundResource(R.drawable.shape_english_rectangle);
            binding.arabicLanguage.setBackgroundResource(R.drawable.shape_green_rectangle);
            binding.arabicLanguage.setTextColor(Color.WHITE);
            binding.englishLanguage.setTextColor(Color.GRAY);

        }

        binding.arabicLanguage.setOnClickListener(this);
        binding.cancelLanguage.setOnClickListener(this);
        binding.englishLanguage.setOnClickListener(this);
        binding.doit.setOnClickListener(this);
        return binding.getRoot();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.arabic_language:
                binding.englishLanguage.setBackgroundResource(R.drawable.shape_english_rectangle);
                binding.arabicLanguage.setBackgroundResource(R.drawable.shape_green_rectangle);
                binding.arabicLanguage.setTextColor(Color.WHITE);
                binding.englishLanguage.setTextColor(Color.GRAY);

                language = "ar";

                break;


            case R.id.english_language:
                binding.arabicLanguage.setTextColor(Color.GRAY);
                binding.englishLanguage.setTextColor(Color.WHITE);
                binding.arabicLanguage.setBackgroundResource(R.drawable.shape_english_rectangle);
                binding.englishLanguage.setBackgroundResource(R.drawable.shape_green_rectangle);
                language = "en";


                break;


            case R.id.cancel_language:
                replace(new MoreFragment(),R.id.hom_container,getFragmentManager().beginTransaction());
                break;


            case R.id.doit:

                if (language!=null){

                    setlanguage(language);
                    refreshTheApp();
                }

                break;
        }
    }


    private void setlanguage(String yourLanguage){

        manager.saveLanguage(yourLanguage);

        Locale locale = new Locale(yourLanguage);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getActivity().getResources().updateConfiguration(config,
                getActivity().getResources().getDisplayMetrics());


    }

    private void refreshTheApp(){

        Intent intent = getActivity().getIntent();
        getActivity().finish();
        startActivity(intent);
    }
}
