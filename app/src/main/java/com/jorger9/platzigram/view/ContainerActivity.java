package com.jorger9.platzigram.view;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jorger9.platzigram.R;
import com.jorger9.platzigram.post.view.HomeFragment;
import com.jorger9.platzigram.view.fragment.ProfileFragment;
import com.jorger9.platzigram.view.fragment.SearchFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;



public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottombar);

        bottomBar.setDefaultTab(R.id.home);

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.home){
                    replaceFragment( new HomeFragment());

                }
                else if(tabId == R.id.profile){
                    replaceFragment( new ProfileFragment());
                }
                else if(tabId==R.id.search){

                    replaceFragment( new SearchFragment());
                }
            }
        });
    }

    private void replaceFragment(Fragment fragment){

        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null).commit();
    }
}
