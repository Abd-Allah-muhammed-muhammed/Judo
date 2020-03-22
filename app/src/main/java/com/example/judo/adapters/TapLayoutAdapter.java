package com.example.judo.adapters;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.judo.ui.competitions.details.CompetitionInformationFragment;
import com.example.judo.ui.competitions.details.mangment.MangmentCompetitionFragment;
import com.example.judo.ui.competitions.details.photos.CompetitionPhotosFragment;
import com.example.judo.ui.competitions.details.rank.CompetitionRanksFragment;


public class TapLayoutAdapter extends FragmentPagerAdapter {

    public TapLayoutAdapter(FragmentManager fm) {
        super(fm);
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
                return "المعلومات"  ;
            case 1:
                return "المراكز";
            case 2 :
                return "الصور";

            case 3 :

                return "المنظمون";
        }
        return super.getPageTitle(position);
    }
}