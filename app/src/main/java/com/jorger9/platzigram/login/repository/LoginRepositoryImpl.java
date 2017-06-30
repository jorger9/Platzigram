package com.jorger9.platzigram.login.repository;

import com.jorger9.platzigram.login.presenter.LoginPresenter;

/**
 * Created by jorger9 on 6/23/17.
 */

public class LoginRepositoryImpl implements LoginRepository{

    private LoginPresenter loginPresenter;

    public LoginRepositoryImpl(LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }

    @Override
    public void signIn(String userName, String password) {
        boolean success = true;

        if(success){
            loginPresenter.loginSuccess();
        }
        else {
            loginPresenter.loginError("Ocurrió un error");
        }

    }
}
