package com.jorger9.platzigram.login.presenter;

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;
import com.jorger9.platzigram.login.interactor.LoginInteractor;
import com.jorger9.platzigram.login.view.LoginView;

/**
 * Created by jorger9 on 6/23/17.
 */

public interface LoginPresenter {

    void signIn(String userName, String password, Activity activity, FirebaseAuth firebaseAuth);
    void loginSuccess();
    void loginError(String error);
}
