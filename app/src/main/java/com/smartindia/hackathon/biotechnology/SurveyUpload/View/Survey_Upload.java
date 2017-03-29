package com.smartindia.hackathon.biotechnology.SurveyUpload.View;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

import java.io.IOException;

public class Survey_Upload extends AppCompatActivity implements  SurveyUploadView {

    private ProgressBar progressbar;
    private RetrofitSurveyUploadProvider retrofitSurveyUploadProvider;
    private SurveyUploadPresenter surveyUploadPresenter;
    private Button buttonChoose;
    private Button buttonUpload;
    private EditText editText;
    private Uri filePath;
    private int PICK_FILE_REQUEST = 1;

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
    }
    @Override
    public void showLoading(boolean show) {
        if (show) {
            progressbar.setVisibility(View.VISIBLE);
        } else {
            progressbar.setVisibility(View.INVISIBLE);
        }
    }

    public String getPath(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        String document_id = cursor.getString(0);
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
        cursor.close();

        cursor = getContentResolver().query(
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null, MediaStore.Images.Media._ID + " = ? ", new String[]{document_id}, null);
        cursor.moveToFirst();
        String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
        cursor.close();

        return path;
    }

    @Override
    public void onSurveyUploadVerified() {
        Toast.makeText(getApplicationContext(), "Upload Successful", Toast.LENGTH_SHORT).show();
    }
}
