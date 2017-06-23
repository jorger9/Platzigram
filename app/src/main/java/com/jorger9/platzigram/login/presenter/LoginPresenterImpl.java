package com.jorger9.platzigram.login.presenter;

import com.jorger9.platzigram.login.interactor.LoginInteractor;
import com.jorger9.platzigram.login.interactor.LoginInteractorImpl;
import com.jorger9.platzigram.login.view.LoginView;

/**
 * Created by jorger9 on 6/23/17.
 */

public class LoginPresenterImpl implements LoginPresenter{


    private LoginView loginView;
    private LoginInteractor loginInteractor;


    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        loginInteractor = new LoginInteractorImpl(this);
    }

    @Override
    public void signIn(String userName, String password) {

        loginView.disableInputs();
        loginView.showProgressBar();
        loginInteractor.signIn(userName,password);
    }

    @Override
    public void loginSuccess() {
        loginView.goHome();
        loginView.hideProgressBar();


    }

    @Override
    public void loginError(String error) {
        loginView.enableInputs();
        loginView.hideProgressBar();
        loginView.loginError(error);

    }
}