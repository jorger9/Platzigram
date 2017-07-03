package com.jorger9.platzigram.login.interactor;

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by jorger9 on 6/23/17.
 */

public interface LoginInteractor {

    void signIn(String userName, String password, Activity activity, FirebaseAuth firebaseAuth);
}
