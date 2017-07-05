package com.jorger9.platzigram.login.repository;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
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
    public void signIn(final String userName, String password, final Activity activity, final FirebaseAuth firebaseAuth) {

        firebaseAuth.signInWithEmailAndPassword(userName, password).addOnCompleteListener(activity,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    FirebaseUser user = task.getResult().getUser();
                    SharedPreferences preferences = activity.getSharedPreferences("USER", Context.MODE_PRIVATE);

                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("email",user.getEmail());
                    editor.commit();


                    loginPresenter.loginSuccess();
                }
                else {
                    loginPresenter.loginError("Ocurrió un error");
                }
            }
        });

    }
}
