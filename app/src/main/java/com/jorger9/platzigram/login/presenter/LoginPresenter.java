package com.jorger9.platzigram.login.presenter;

import com.jorger9.platzigram.login.interactor.LoginInteractor;
import com.jorger9.platzigram.login.view.LoginView;

/**
 * Created by jorger9 on 6/23/17.
 */

public interface LoginPresenter {

    void signIn(String userName, String password);
    void loginSuccess();
    void loginError(String error);
}
