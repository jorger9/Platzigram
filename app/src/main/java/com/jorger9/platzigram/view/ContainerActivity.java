package com.jorger9.platzigram.view;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.jorger9.platzigram.R;
import com.jorger9.platzigram.login.view.LoginActivity;
import com.jorger9.platzigram.post.view.HomeFragment;
import com.jorger9.platzigram.view.fragment.ProfileFragment;
import com.jorger9.platzigram.view.fragment.SearchFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;



public class ContainerActivity extends AppCompatActivity {

    private static final String TAG = "ContainerActivity";
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        fireBaseInitialize();

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

    private void fireBaseInitialize() {

        firebaseAuth = FirebaseAuth.getInstance();

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

                if(firebaseUser != null){
                    Log.w(TAG,"Usuario logueado" + firebaseUser.getEmail());
                }
                else
                {
                    Log.w(TAG,"Usuario no logueado");
                }

            }
        };
    }

    private void replaceFragment(Fragment fragment){

        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.mSignout:
                firebaseAuth.signOut();
                if(LoginManager.getInstance() != null)
                {
                    LoginManager.getInstance().logOut();
                }

                Intent i = new Intent(ContainerActivity.this, LoginActivity.class);
                startActivity(i);
                break;
            case R.id.mAbout:
                Toast.makeText(this, "Platzigram by Jorge", Toast.LENGTH_SHORT).show();

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
