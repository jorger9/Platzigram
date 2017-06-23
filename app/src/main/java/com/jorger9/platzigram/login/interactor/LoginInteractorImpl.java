package com.jorger9.platzigram.login.interactor;

import com.jorger9.platzigram.login.presenter.LoginPresenter;
import com.jorger9.platzigram.login.repository.LoginRepository;
import com.jorger9.platzigram.login.repository.LoginRepositoryImpl;

/**
 * Created by jorger9 on 6/23/17.
 */

public class LoginInteractorImpl implements LoginInteractor {
    private LoginPresenter loginPresenter;
    private LoginRepository loginRepository;

    public LoginInteractorImpl(LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
        loginRepository = new LoginRepositoryImpl(loginPresenter);
    }

    @Override
    public void signIn(String userName, String password) {

        loginRepository.signIn(userName,password);

    }
}
