package com.example.judo.helper;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Locale;

public class PrefManager {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "judo_abdalah";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static final String LANGUAGE = "language";

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }


    public void saveLanguage(String token) {
        editor.putString(LANGUAGE, token);
        editor.commit();
    }





    public String getLanguage() {
        String langdefalt = Locale.getDefault().getLanguage();
        return pref.getString(LANGUAGE, langdefalt);

    }







    public void clear() {
        editor.clear();
        editor.commit();


    }

}