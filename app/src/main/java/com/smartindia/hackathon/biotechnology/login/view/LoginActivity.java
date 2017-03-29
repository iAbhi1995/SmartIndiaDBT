package com.smartindia.hackathon.biotechnology.login.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
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
import com.smartindia.hackathon.biotechnology.login.model.MockLoginProvider;
import com.smartindia.hackathon.biotechnology.login.model.data.LoginData;
import com.smartindia.hackathon.biotechnology.login.model.data.OTPdata;
import com.smartindia.hackathon.biotechnology.login.model.data.RetrofitOTPProvider;
import com.smartindia.hackathon.biotechnology.login.presenter.LoginPresenter;
import com.smartindia.hackathon.biotechnology.login.presenter.LoginPresenterImpl;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener,LoginView,OTPView {

    Button btnSignOut;
    SharedPrefs session;
    private SignInButton signInButton;
    private GoogleApiClient mGoogleApiClient;
    private int RC_SIGN_IN = 001;
    private String name;
    private String email;
    private String user_type;
    private EditText prfsrEmail;
    private ProgressBar progressBar;
    private LoginPresenter loginPresenter;
    private EditText userName;
    private String otp;
    private LoginPresenter otpPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        session = new SharedPrefs(LoginActivity.this);
        progressBar=(ProgressBar)findViewById(R.id.prgrsbr);
        userName=(EditText)findViewById(R.id.user_name);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        signInButton = (SignInButton) findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        signInButton.setOnClickListener(this);
        prfsrEmail=(EditText)findViewById(R.id.emailID);
        btnSignOut = (Button) findViewById(R.id.btn_sign_out);
        btnSignOut.setOnClickListener(this);
        if (session.isLoggedIn()) {
            updateUI(true);
        }
//        loginPresenter = new LoginPresenterImpl(new RetrofitLoginProvider(),this);
        loginPresenter = new LoginPresenterImpl(new MockLoginProvider(),this);
        otpPresenter =new LoginPresenterImpl(new RetrofitOTPProvider(),this);
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

    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void signOut() {
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                updateUI(false);
            }
        });
        //Snackbar.make(findViewById(R.id.relLoginAcvty), "Signed Out", Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
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
            user_type="1";
            loginPresenter.requestLogin(name,email,user_type);
            //Snackbar.make(findViewById(R.id.relLoginAcvty), "Signing in Successfully as " + name + " with email id " + email, Snackbar.LENGTH_LONG).setAction("Action", null).show();
            updateUI(true);
        } else {
            // Signed out, show unauthenticated UI.
            updateUI(false);
        }
    }

    private void updateUI(boolean b) {
        if (b) {
            session.setLogin(b);
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
        Snackbar.make(findViewById(R.id.relLoginAcvty), message, Snackbar.LENGTH_LONG).setAction("Action", null).show();

    }

    @Override
    public void onLoginVerified(LoginData loginData) {
        session.setAccessToken(loginData.getAccess_token());
        session.setLogin(true);
        Intent i = new Intent(this, Home_page.class);
        startActivity(i);
        finish();
    }

    public void ProfessorLogin(View v)
    {
        user_type="0";
        email=prfsrEmail.getText().toString().trim();
        name=userName.getText().toString().trim();
        if(!email.contains("@yahoo")||!email.contains("@hotmail")||!email.contains("@gmail")||!email.contains("@rediff"))
        {
            Snackbar.make(findViewById(R.id.relLoginAcvty), "Please enter your college mail id!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }
        else
        {
            loginPresenter.requestLogin(name,email,user_type);
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(LoginActivity.this);
            alertDialog.setTitle("OTP Confirmation");
            alertDialog.setMessage("Enter OTP");

            final EditText input = new EditText(LoginActivity.this);
            input.setInputType(InputType.TYPE_CLASS_PHONE);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            input.setLayoutParams(lp);
            alertDialog.setView(input);

            alertDialog.setPositiveButton("YES",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which)
                        {
                            otp = input.getText().toString();
                            otpPresenter.requestOtp(otp);
                        }
                    });

            alertDialog.setNegativeButton("NO",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            alertDialog.show();
        }
        }
        public void onOTPVerified(OTPdata otpData)
        {
            session.setAccessToken(otpData.getAccess_token());
            session.setLogin(true);
            Intent i = new Intent(this, Home_page.class);
            startActivity(i);
            finish();
        }
    }

