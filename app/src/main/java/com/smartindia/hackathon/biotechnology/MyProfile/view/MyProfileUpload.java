package com.smartindia.hackathon.biotechnology.MyProfile.view;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.smartindia.hackathon.biotechnology.MyProfile.Model.RetrofitProfileProvider;
import com.smartindia.hackathon.biotechnology.MyProfile.Presenter.MyProfilePresenter;
import com.smartindia.hackathon.biotechnology.MyProfile.Presenter.MyProfilePresenterIml;
import com.smartindia.hackathon.biotechnology.R;
import com.smartindia.hackathon.biotechnology.helper.FilePath;

import java.io.IOException;

public class MyProfileUpload extends AppCompatActivity  implements MyProfileView,View.OnClickListener {

    private ProgressBar progressbar;
    private MyProfilePresenter myProfilePresenter;
    private Button add_pdf;
    private ImageButton add_pic;
    private Button buttonUpload;
    private ImageView imageView;
    private Uri file_pdf;
    private Uri file_image;

    private int PICK_IMAGE_REQUEST = 1;
    private int PICK_FILE_REQUEST = 2;
    private static final int STORAGE_PERMISSION_CODE = 123;


    public String user_institution;
    public String user_skills;
    public String user_place;
    public String user_currentyear;
    public String user_qualification;
    public String user_experience;
    private Bitmap bitmap;

    public EditText user_institutio,user_skill,user_plac,user_currentyea,user_qualificatio,user_experienc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile_upload);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        requestStoragePermission();

        //Initializing views
        add_pdf = (Button) findViewById(R.id.add_pdf);
        buttonUpload = (Button) findViewById(R.id.buttonUpload);
        imageView = (ImageButton) findViewById(R.id.add_pic);

        add_pdf.setOnClickListener(this);
        add_pic.setOnClickListener(this);
        buttonUpload.setOnClickListener(this);

        progressbar = (ProgressBar)findViewById(R.id.progressbar);
        user_institutio=(EditText) findViewById(R.id.user_institution);
        user_skill=(EditText) findViewById(R.id.user_skills);
        user_plac=(EditText) findViewById(R.id.user_place);
        user_currentyea=(EditText) findViewById(R.id.user_currentyear);
        user_qualificatio=(EditText) findViewById(R.id.user_qualification);
        user_experienc=(EditText) findViewById(R.id.user_experience);

        user_institution = user_institutio.getText().toString();
        user_skills=user_skill.getText().toString();
        user_place=user_plac.getText().toString();
        user_currentyear=user_currentyea.getText().toString();
        user_qualification=user_qualificatio.getText().toString();
        user_experience=user_experienc.getText().toString();

        myProfilePresenter= new MyProfilePresenterIml(this,
                new RetrofitProfileProvider());
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
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            file_image = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), file_image);
                imageView.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (requestCode == PICK_FILE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            file_pdf = data.getData();
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
    public void onMyProfileUploadVerified() {
        Toast.makeText(getApplicationContext(), "Upload Successful", Toast.LENGTH_SHORT).show();
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
    public void onClick(View v) {
        if (v == add_pic||v == add_pdf) {
            showFileChooser();
        }
        if (v == buttonUpload) {
            sendRequest();
        }
    }
    public void sendRequest()
    {
        FilePath FilePath = new FilePath();
        String image_path = FilePath.getPath(getApplicationContext(),file_image);
        String pdf_path = FilePath.getPath(getApplicationContext(),file_pdf);
        myProfilePresenter.requestUpload(image_path,pdf_path,user_institution,user_skills,user_place,user_currentyear,user_qualification,user_experience);
    }
}
