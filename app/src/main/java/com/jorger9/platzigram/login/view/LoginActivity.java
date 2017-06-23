package com.jorger9.platzigram.login.view;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jorger9.platzigram.R;
import com.jorger9.platzigram.login.presenter.LoginPresenter;
import com.jorger9.platzigram.login.presenter.LoginPresenterImpl;
import com.jorger9.platzigram.view.ContainerActivity;
import com.jorger9.platzigram.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity implements LoginView{

    private TextInputEditText userName, password;
    private Button login;
    private ProgressBar progressBarLogin;
    private LoginPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName         = (TextInputEditText)findViewById(R.id.username);
        password         = (TextInputEditText)findViewById(R.id.password);
        login            = (Button)findViewById(R.id.login);
        progressBarLogin = (ProgressBar)findViewById(R.id.progressbarlogin);

        hideProgressBar();
        presenter = new LoginPresenterImpl(this);

        login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                presenter.signIn(userName.getText().toString(),password.getText().toString());
            }
        });
    }


    @Override
    public void enableInputs() {

        userName.setEnabled(true);
        password.setEnabled(true);
        login.setEnabled(true);
    }

    @Override
    public void disableInputs() {

        userName.setEnabled(false);
        password.setEnabled(false);
        login.setEnabled(false);

    }

    @Override
    public void showProgressBar() {
        progressBarLogin.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgressBar() {
        progressBarLogin.setVisibility(View.GONE);

    }

    @Override
    public void loginError(String error) {
        Toast.makeText(this, getString(R.string.login_error) + error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goCreateAccount() {
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }

    @Override
    public void goHome() {
        Intent intent = new Intent(this, ContainerActivity.class);
        startActivity(intent);
    }

    @Override
    public void openURL(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
        browserIntent.setData(Uri.parse("http://www.platzigram.com"));
        startActivity(browserIntent);
    }

}
