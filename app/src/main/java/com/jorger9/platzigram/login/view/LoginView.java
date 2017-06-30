package com.jorger9.platzigram.login.view;

import android.view.View;

/**
 * Created by jorger9 on 6/22/17.
 */

public interface LoginView {

    void enableInputs();
    void disableInputs();

    void showProgressBar();
    void hideProgressBar();

    void loginError(String error);


    void goCreateAccount(View view);
    void goHome();
    void openURL(View view);
}
