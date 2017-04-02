package com.smartindia.hackathon.biotechnology.login.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.smartindia.hackathon.biotechnology.R;
import com.smartindia.hackathon.biotechnology.helper.SharedPrefs;
import com.smartindia.hackathon.biotechnology.home.Home_page;
import com.smartindia.hackathon.biotechnology.login.model.RetrofitLoginProvider;
import com.smartindia.hackathon.biotechnology.login.model.data.LoginData;
import com.smartindia.hackathon.biotechnology.login.model.data.ProfLogInData;
import com.smartindia.hackathon.biotechnology.login.presenter.LoginPresenter;
import com.smartindia.hackathon.biotechnology.login.presenter.LoginPresenterImpl;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener, LoginView {

    Button btnSignOut;
    SharedPrefs session;
    private SignInButton signInButton;
    private GoogleApiClient mGoogleApiClient;
    private int RC_SIGN_IN = 001;
    private String name;
    private String email, password1;
    private EditText prfsrEmail;
    private ProgressBar progressBar;
    private LoginPresenter loginPresenter;
    private EditText password;
    private String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        session = new SharedPrefs(LoginActivity.this);
        progressBar = (ProgressBar) findViewById(R.id.prgrsbr);
        password = (EditText) findViewById(R.id.password);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        signInButton = (SignInButton) findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(this);
        prfsrEmail = (EditText) findViewById(R.id.emailID);
        btnSignOut = (Button) findViewById(R.id.btn_sign_out);
        btnSignOut.setOnClickListener(this);
        if (session.isLoggedIn()) {
            updateUI(true);
        }
        loginPresenter = new LoginPresenterImpl(new RetrofitLoginProvider(), this);
//            loginPresenter=new LoginPresenterImpl(new MockLoginProvider(),this);
    }

    public void ProfessorRegister(View view) {
        Intent intent = new Intent(this, InstituteRegister.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.sign_in_button:
                signIn();
                break;
            case R.id.btn_sign_out:
                signOut();
                break;
        }

    }

    public void ProfessorLogin(View v) {
        Log.d("abhi", "In Login");
        email = prfsrEmail.getText().toString().trim();
        password1 = password.getText().toString().trim();
        if (email.equals("") && password1.equals("")) {
            Snackbar.make(findViewById(R.id.relLoginAcvty), "Please Enter a Proper Mail id and Password", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }
        loginPresenter.requestProfLogin(email, password1);
    }

    private void signIn() {
        Log.d("abhi","In sign in");
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void signOut() {
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                updateUI(false);
                session.setLogin(false);
                session.setAccessToken("");
            }
        });
        //Snackbar.make(findViewById(R.id.relLoginAcvty), "Signed Out", Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("abhi","In Activity Result");
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Log.d("abhi","In Request code");

            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();
            name = acct.getDisplayName();
            email = acct.getEmail();
            session.setKeyType("1");

            Log.d("abhi","handle sign in result");
            id = acct.getId().toString();
            loginPresenter.requestLogin(name, email, id);
            updateUI(true);
        } else {
            Log.d("abhi","handle sign in result"+result.isSuccess());
            updateUI(false);
        }
    }

    private void updateUI(boolean b) {
        if (b) {
            session.setLogin(b);

            Log.d("abhi","Updating Ui");
            signInButton.setEnabled(false);
            signInButton.setVisibility(View.INVISIBLE);
            btnSignOut.setEnabled(true);
            btnSignOut.setVisibility(View.VISIBLE);
        } else {
            session.setLogin(b);
            signInButton.setEnabled(true);
            signInButton.setVisibility(View.VISIBLE);
            btnSignOut.setEnabled(false);
            btnSignOut.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Snackbar.make(findViewById(R.id.relLoginAcvty), "Connection Problem! Try Again", Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }

    @Override
    public void showProgressBar(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(findViewById(R.id.relLoginAcvty), message, Snackbar.LENGTH_LONG).setAction("Action", null).show();

    }

    @Override
    public void onLoginVerified(LoginData loginData) {
        session.setAccessToken(loginData.getAccess_token());
        session.setLogin(true);
        session.setKeyType("1");
        Log.d("Login","Accessing");
        session.setAccessToken(loginData.getAccess_token());
        Intent i = new Intent(this, Home_page.class);
        startActivity(i);
        finish();
    }

    @Override
    public void signOutonError() {
        signOut();
    }

    public void onProfessorLoginVerified(ProfLogInData profLogInData) {
        session.setAccessToken(profLogInData.getAccess_token());
        session.setLogin(true);
        session.setAccessToken(profLogInData.getAccess_token());
        session.setKeyType("0");
        Intent i = new Intent(this, Home_page.class);
        startActivity(i);
        finish();
    }
}