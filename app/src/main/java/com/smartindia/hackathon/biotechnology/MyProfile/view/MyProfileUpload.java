package com.smartindia.hackathon.biotechnology.MyProfile.view;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
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
import android.widget.RadioGroup;
import android.widget.Toast;

import com.smartindia.hackathon.biotechnology.MyProfile.Model.RetrofitProfileProvider;
import com.smartindia.hackathon.biotechnology.MyProfile.Presenter.MyProfilePresenter;
import com.smartindia.hackathon.biotechnology.MyProfile.Presenter.MyProfilePresenterIml;
import com.smartindia.hackathon.biotechnology.R;
import com.smartindia.hackathon.biotechnology.helper.FilePath;
import com.smartindia.hackathon.biotechnology.helper.SharedPrefs;

import java.io.IOException;

public class MyProfileUpload extends AppCompatActivity implements MyProfileView, View.OnClickListener {

    private static final int STORAGE_PERMISSION_CODE = 123;
    public String user_institution;
    public String user_skills;
    public String user_place;
    public String user_currentyear;
    public String user_qualification;
    public String user_experience;
    public EditText user_institutio, user_skill, user_plac, user_currentyea, user_qualificatio, user_experienc;
    private ProgressBar progressbar;
    private MyProfilePresenter myProfilePresenter;
    private Button add_pdf;
    private ImageView add_pic;
    private Button buttonUpload;
    private Uri file_pdf;
    private Uri file_image;
    private int PICK_IMAGE_REQUEST = 1;
    private int PICK_FILE_REQUEST = 2;
    private Bitmap bitmap;
    private RadioGroup personTypeGroup;
    private SharedPrefs sharedPrefs;

    public static Bitmap getRoundedRectBitmap(Bitmap bitmap, int pixels) {
        Bitmap result = null;
        try {
            result = Bitmap.createBitmap(99, 99, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(result);

            int color = 0xff424242;
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, 150, 150);

            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(color);
            canvas.drawCircle(50, 50, 50, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect, paint);

        } catch (NullPointerException e) {
        } catch (OutOfMemoryError o) {
        }
        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile_upload);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sharedPrefs = new SharedPrefs(this);
        requestStoragePermission();

        //Initializing views
        add_pdf = (Button) findViewById(R.id.add_pdf);
        buttonUpload = (Button) findViewById(R.id.button_upload);
        add_pic = (ImageView) findViewById(R.id.add_pic);

        personTypeGroup = (RadioGroup) findViewById(R.id.personType);

        if (sharedPrefs != null && sharedPrefs.isLoggedIn() && sharedPrefs.getKeyType() == "2")
            personTypeGroup.setVisibility(View.GONE);


        add_pdf.setOnClickListener(this);
        add_pic.setOnClickListener(this);
        buttonUpload.setOnClickListener(this);

        progressbar = (ProgressBar) findViewById(R.id.progressbar);
        user_institutio = (EditText) findViewById(R.id.user_institution);
        user_skill = (EditText) findViewById(R.id.user_skills);
        user_plac = (EditText) findViewById(R.id.user_place);
        user_currentyea = (EditText) findViewById(R.id.user_currentyear);
        user_qualificatio = (EditText) findViewById(R.id.user_qualification);
        user_experienc = (EditText) findViewById(R.id.user_experience);
        user_institution = user_institutio.getText().toString();
        user_skills = user_skill.getText().toString();
        user_place = user_plac.getText().toString();
        user_currentyear = user_currentyea.getText().toString();
        user_qualification = user_qualificatio.getText().toString();
        user_experience = user_experienc.getText().toString();

        myProfilePresenter = new MyProfilePresenterIml(this,
                new RetrofitProfileProvider());
    }

    private void showFileChooser(View v) {
        Intent intent = new Intent();
        if (v == add_pic) {
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
        } else {
            intent.setType("application/pdf");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select File"), PICK_FILE_REQUEST);
        }
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
                Bitmap resized = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
                Bitmap conv_bm = getRoundedRectBitmap(resized, 100);
                add_pic.setImageBitmap(conv_bm);

            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.d("Ayush1", file_image.toString());
        }
        if (requestCode == PICK_FILE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            file_pdf = data.getData();
        }
    }

    private void requestStoragePermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
            return;

        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
        }
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
        if (v == add_pic || v == add_pdf) {
            showFileChooser(v);
        }
        if (v == buttonUpload) {
            sendRequest();
        }
    }

    public void sendRequest() {
        FilePath FilePath = new FilePath();
        int selectedId = personTypeGroup.getCheckedRadioButtonId();

        if (selectedId == R.id.student) {
            sharedPrefs.setKeyType("0");
        } else {
            sharedPrefs.setKeyType("1");
        }

        if (file_pdf == null || file_image == null) {
            Toast.makeText(getApplicationContext(), "You have not uploaded either image or file.", Toast.LENGTH_SHORT).show();
        } else {
            String pdf_path = com.smartindia.hackathon.biotechnology.helper.FilePath.getPath(getApplicationContext(), file_pdf);
            String image_path = com.smartindia.hackathon.biotechnology.helper.FilePath.getPath(getApplicationContext(), file_image);
            myProfilePresenter.requestUpload(sharedPrefs.getAccessToken(), sharedPrefs.getKeyType(), image_path, pdf_path, user_institution, user_skills, user_place, user_currentyear, user_qualification, user_experience);

        }
    }
}