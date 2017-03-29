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
import com.smartindia.hackathon.biotechnology.SurveyUpload.Model.RetrofitSurveyUploadProvider;
import com.smartindia.hackathon.biotechnology.SurveyUpload.Presenter.SurveyUploadPresenter;
import com.smartindia.hackathon.biotechnology.SurveyUpload.Presenter.SurveyUploadPresenterImpl;
import com.smartindia.hackathon.biotechnology.helper.FilePath;

import java.io.IOException;

public class Survey_Upload extends AppCompatActivity implements  SurveyUploadView ,View.OnClickListener{

    private ProgressBar progressbar;
    private RetrofitSurveyUploadProvider retrofitSurveyUploadProvider;
    private SurveyUploadPresenter surveyUploadPresenter;
    private Button buttonChoose;
    private Button buttonUpload;
    private EditText editText;
    private Uri filePath;
    private int PICK_FILE_REQUEST = 1;
    private static final int STORAGE_PERMISSION_CODE = 123;
    String survey_title;
    String survey_description;
    String survey_scale;
    String survey_question1;
    String survey_question2;
    String survey_question3;
    String survey_question4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey__upload);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        requestStoragePermission();

        //Initializing views
        buttonChoose = (Button) findViewById(R.id.buttonChoose);
        buttonUpload = (Button) findViewById(R.id.buttonUpload);
        editText = (EditText) findViewById(R.id.editTextName);

        buttonChoose.setOnClickListener(this);
        buttonUpload.setOnClickListener(this);

        EditText survey_titl,survey_descriptio,survey_scal,survey_questio1,survey_questio2,survey_questio3,survey_questio4;

        survey_titl=(EditText) findViewById(R.id.survey_title);
        survey_scal=(EditText) findViewById(R.id.survey_scale);
        survey_descriptio=(EditText) findViewById(R.id.survey_description);
        survey_questio1=(EditText) findViewById(R.id.survey_question1);
        survey_questio2=(EditText) findViewById(R.id.survey_question2);
        survey_questio3=(EditText) findViewById(R.id.survey_question3);
        survey_questio4=(EditText) findViewById(R.id.survey_question4);

        String survey_title = survey_titl.toString();
        String survey_description = survey_descriptio.toString();
        String survey_scale = survey_scal.toString();
        String survey_question1 = survey_questio1.toString();
        String survey_question2 = survey_questio2.toString();
        String survey_question3 = survey_questio3.toString();
        String survey_question4 = survey_questio4.toString();

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
            Log.d("Ayush",filePath.toString());
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
       surveyUploadPresenter.requestUpload(path,survey_title,survey_scale,survey_description,survey_question1,survey_question2,survey_question3,survey_question4);
    }
}
