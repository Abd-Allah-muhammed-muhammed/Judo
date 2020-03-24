package com.example.judo.adapters;


import android.app.Activity;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.judo.R;
import com.example.judo.ui.competitions.details.CompetitionInformationFragment;
import com.example.judo.ui.competitions.details.mangment.MangmentCompetitionFragment;
import com.example.judo.ui.competitions.details.photos.CompetitionPhotosFragment;
import com.example.judo.ui.competitions.details.rank.CompetitionRanksFragment;


public class TapLayoutAdapter extends FragmentPagerAdapter {


    Activity activity ;
    public TapLayoutAdapter(FragmentManager fm , Activity activity) {
        super(fm);
       this.activity = activity;
    }

    @Override
    public Fragment getItem(int pos) {
        switch (pos){
            case 1:
                return new CompetitionRanksFragment();

                case 2 :
                    return  new CompetitionPhotosFragment();

            case 3 :
                return new MangmentCompetitionFragment();
            case 0:
            default:
                return new CompetitionInformationFragment();
        }
    }
    @Override
    public int getCount() {
        return 4;
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0:
                return activity.getString(R.string.informations)  ;
            case 1:
                return activity.getString(R.string.rank);
            case 2 :
                return activity.getString(R.string.photos);

            case 3 :

                return activity.getString(R.string.mangers);
        }
        return super.getPageTitle(position);
    }
}