package com.smartindia.hackathon.biotechnology;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {

    Button btnSignOut;
    SessionManager session;
    private SignInButton signInButton;
    private GoogleApiClient mGoogleApiClient;
    private int RC_SIGN_IN = 001;
    private String user_id;
    private String name;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        session = new SessionManager(LoginActivity.this);

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
        btnSignOut = (Button) findViewById(R.id.btn_sign_out);
        btnSignOut.setOnClickListener(this);
        if (session.isLoggedIn()) {
            updateUI(true);
        }

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
            // ...
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
            user_id = acct.getId();
            email = acct.getEmail();
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
}
