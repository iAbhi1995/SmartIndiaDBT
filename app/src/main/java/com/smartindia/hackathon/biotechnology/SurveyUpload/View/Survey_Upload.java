package com.smartindia.hackathon.biotechnology.SurveyUpload.View;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.smartindia.hackathon.biotechnology.R;
import com.smartindia.hackathon.biotechnology.SurveyUpload.Model.Data.MockSurveyUploadProvider;
import com.smartindia.hackathon.biotechnology.SurveyUpload.Model.RetrofitSurveyUploadProvider;
import com.smartindia.hackathon.biotechnology.SurveyUpload.Presenter.SurveyUploadPresenter;
import com.smartindia.hackathon.biotechnology.SurveyUpload.Presenter.SurveyUploadPresenterImpl;
import com.smartindia.hackathon.biotechnology.helper.FilePath;
import com.smartindia.hackathon.biotechnology.helper.SharedPrefs;

import java.io.IOException;

public class Survey_Upload extends AppCompatActivity implements  SurveyUploadView ,View.OnClickListener{

    private ProgressBar progressbar;
    private SurveyUploadPresenter surveyUploadPresenter;
    private Button buttonChoose;
    private Button buttonUpload;
    private SharedPrefs sharedPrefs;
    private EditText editText;
    private Uri filePath;
    private int PICK_FILE_REQUEST = 1;
    private static final int STORAGE_PERMISSION_CODE = 123;
    public EditText survey_title,survey_description,survey_scale,survey_question1,survey_question2,survey_question3,survey_question4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey__upload);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sharedPrefs=new SharedPrefs(this);
        requestStoragePermission();

        //Initializing views
        buttonChoose = (Button) findViewById(R.id.buttonChoose);
        buttonUpload = (Button) findViewById(R.id.buttonUpload);
        editText = (EditText) findViewById(R.id.editTextName);

        buttonChoose.setOnClickListener(this);
        buttonUpload.setOnClickListener(this);

        surveyUploadPresenter = new SurveyUploadPresenterImpl(this,
                new RetrofitSurveyUploadProvider());
    }

    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_FILE_REQUEST);
    }

    @Override
    public void showMessage(String message) {

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_FILE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            filePath = data.getData();
        }
    }

    private void requestStoragePermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
            return;

        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission
        }
        //And finally ask for the permission
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
    }

    @Override
    public void showLoading(boolean show) {
        if (show) {
            progressbar.setVisibility(View.VISIBLE);
        } else {
            progressbar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        //Checking the request code of our request
        if (requestCode == STORAGE_PERMISSION_CODE) {

            //If permission is granted
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //Displaying a toast
                Toast.makeText(this, "Permission granted now you can read the storage", Toast.LENGTH_LONG).show();
            } else {
                //Displaying another toast if permission is not granted
                Toast.makeText(this, "Oops you just denied the permission", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onSurveyUploadVerified() {
        Toast.makeText(getApplicationContext(), "Upload Successful", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View v) {
        if (v == buttonChoose) {
            showFileChooser();
        }
        if (v == buttonUpload) {
            sendRequest();
        }
    }
    public void sendRequest()
    {
        FilePath FilePath = new FilePath();
        String path = FilePath.getPath(getApplicationContext(),filePath);
        progressbar = (ProgressBar)findViewById(R.id.progressbar);
        survey_title=(EditText) findViewById(R.id.survey_title);
        survey_scale=(EditText) findViewById(R.id.survey_scale);
        survey_description=(EditText) findViewById(R.id.survey_description);
        survey_question1=(EditText) findViewById(R.id.survey_question1);
        survey_question2=(EditText) findViewById(R.id.survey_question2);
        survey_question3=(EditText) findViewById(R.id.survey_question3);
        survey_question4=(EditText) findViewById(R.id.survey_question4);


        Log.d("Ayush1", "yahan");
        Log.d("Ayush1", survey_question1.getText().toString());


        surveyUploadPresenter.requestUpload(sharedPrefs.getAccessToken(),sharedPrefs.getKeyType(),path,survey_title.getText().toString(),survey_scale.getText().toString(),survey_description.getText().toString(),survey_question1.getText().toString(),survey_question2.getText().toString(),survey_question3.getText().toString(),survey_question4.getText().toString());
    }
}
