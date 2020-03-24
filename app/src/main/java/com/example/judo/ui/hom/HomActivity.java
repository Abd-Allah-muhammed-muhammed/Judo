package com.example.judo.ui.hom;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.judo.R;

import com.example.judo.databinding.ActivityHomBinding;
import com.example.judo.ui.competitions.CompetitionsFragment;
import com.example.judo.ui.more.MoreFragment;

import com.example.judo.ui.vedios.VediosFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;



import static com.example.judo.helper.HelperMethods.replace;

public class HomActivity extends AppCompatActivity  implements BottomNavigationView.OnNavigationItemSelectedListener {

    ActivityHomBinding binding ;
    private long backTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_hom);
        replace(HomFragment.newInstance(),R.id.hom_container,getSupportFragmentManager().beginTransaction());
        binding.setLifecycleOwner(this);
        setSupportActionBar(binding.toolbar);

        binding.navigation.setOnNavigationItemSelectedListener(this);
        binding.navigation.setItemIconTintList(null);





    }




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.nv_more:
                binding.smallLogo.setVisibility(View.INVISIBLE);
                binding.tollbarTitle.setText(getString(R.string.mor));

                replace(MoreFragment.newInstance(),R.id.hom_container,getSupportFragmentManager().beginTransaction(),"more");
                break;


            case R.id._nv_home :
                binding.smallLogo.setVisibility(View.VISIBLE);
                binding.tollbarTitle.setText(getString(R.string.gudo_union));
                replace(HomFragment.newInstance(),R.id.hom_container,getSupportFragmentManager().beginTransaction(),"home_fragment");

                break;

            case  R.id.nv_videos:
                binding.smallLogo.setVisibility(View.INVISIBLE);
                binding.tollbarTitle.setText(getString(R.string.videos));

                replace(VediosFragment.newInstance(),R.id.hom_container,getSupportFragmentManager().beginTransaction(),"videos_fragment");

                break;

            case R.id.nv_win :

                binding.smallLogo.setVisibility(View.INVISIBLE);
                binding.tollbarTitle.setText(getString(R.string.win));
                replace(CompetitionsFragment.newInstance(),R.id.hom_container,getSupportFragmentManager().beginTransaction(),"videos_fragment");


                break;



        }



        return true;
    }


    @Override
    public void onBackPressed() {
        if (backTime + 3000 >System.currentTimeMillis()){
            
            Intent a = new Intent(Intent.ACTION_MAIN);
            a.addCategory(Intent.CATEGORY_HOME);
            a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(a);
        }else {

            Toast.makeText(this, R.string.press_again, Toast.LENGTH_SHORT).show();
        }
        backTime = System.currentTimeMillis();


       

    }
}
