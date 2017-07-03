package com.jorger9.platzigram.login.repository;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
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
    public void signIn(String userName, String password, Activity activity, FirebaseAuth firebaseAuth) {
        //boolean success = true;

        firebaseAuth.signInWithEmailAndPassword(userName, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    loginPresenter.loginSuccess();
                }
                else {
                    loginPresenter.loginError("Ocurrió un error");
                }
            }
        });

    }
}
