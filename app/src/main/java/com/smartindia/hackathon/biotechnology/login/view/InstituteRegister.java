package com.smartindia.hackathon.biotechnology.login.view;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.smartindia.hackathon.biotechnology.R;
import com.smartindia.hackathon.biotechnology.login.model.RetrofitLoginProvider;
import com.smartindia.hackathon.biotechnology.login.model.data.SignUpResultData;
import com.smartindia.hackathon.biotechnology.login.presenter.LoginPresenter;
import com.smartindia.hackathon.biotechnology.login.presenter.LoginPresenterImpl;

public class InstituteRegister extends AppCompatActivity implements SignUpView,View.OnClickListener{


    EditText signUpMail,userName;
    Button submitButton;
    private ProgressBar progressBar;
    private String email,name;
    LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institute_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        progressBar=(ProgressBar)findViewById(R.id.progressbar);
        signUpMail=(EditText)findViewById(R.id.signUpEmail);
        userName=(EditText)findViewById(R.id.prfsrName);
        submitButton=(Button)findViewById(R.id.signUpButton);
        submitButton.setOnClickListener(this);
//        loginPresenter=new LoginPresenterImpl(new MockLoginProvider(),this);
        loginPresenter=new LoginPresenterImpl(new RetrofitLoginProvider(),this);
    }



    @Override
    public void showProgressBar(boolean show) {
        if(show)
        {
            progressBar.setVisibility(View.VISIBLE);
        }
        else
        {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(findViewById(R.id.layout), message, Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }

    @Override
    public void onBackPressed() {
        handlingBackButton();
        super.onBackPressed();
    }

    @Override
    public void handlingBackButton() {
        loginPresenter.handleBackButton();
    }

    @Override
    public void onSignUpVerified(SignUpResultData signUpResultData) {
        Snackbar.make(findViewById(R.id.layout), "Password has been sent to your email id,please check it and login from your account", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }

    @Override
    public void onClick(View v) {
        if(signUpMail.getText()!=null&&userName.getText()!=null) {
            email = signUpMail.getText().toString().trim();
            name = userName.getText().toString().trim();
        }
        else
            return;
        if(email.contains("@yahoo")||email.contains("@hotmail")||email.contains("@gmail")||email.contains("@rediff"))
        {
            Snackbar.make(findViewById(R.id.layout), "Please enter your college mail id!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }
        else if(!email.contains("@"))
        {
            Snackbar.make(findViewById(R.id.layout), "Please enter correct college mail id!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }
        else if(name.equals(""))
        {
            Snackbar.make(findViewById(R.id.layout), "Please enter a user name!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }
        else
            loginPresenter.requestSignUp(name,email);
    }
}