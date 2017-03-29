package com.smartindia.hackathon.biotechnology.MyProfile.view;


import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;

import com.pkmmte.view.CircularImageView;
import com.smartindia.hackathon.biotechnology.MyProfile.Model.Data.SkillsData;
import com.smartindia.hackathon.biotechnology.R;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyProfileFragment extends Fragment implements MyProfileView {


    private ProgressDialog progressDialog;
    private String mediaPath;
    private MediaStore.Images.Media contentResolver;
    private CircularImageView circularImageView;
    private EditText place,email,college;
    private EditText name,phoneNo;
    private GridView skillsGridView;

    public MyProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_my_profile, container, false);
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Submitting . . .");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);

        circularImageView= (CircularImageView) v.findViewById(R.id.my_profile_pic);
        name=(EditText)v.findViewById(R.id.name);
        college=(EditText)v.findViewById(R.id.college);
        place=(EditText)v.findViewById(R.id.place);
        email=(EditText)v.findViewById(R.id.email);
        phoneNo=(EditText)v.findViewById(R.id.phoneNo);
        skillsGridView=(GridView)v.findViewById(R.id.skillsGrid);

        return v;
    }


    @Override
    public void showMessage(String message) {
        Snackbar.make(getActivity().findViewById(R.id.relMainLayout), message, Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }

    @Override
    public void showLoading(boolean show) {
        if (show)
            progressDialog.show();
        else
            progressDialog.hide();
    }


    @Override
    public void onSkillsReceived(SkillsData skillsData) {
        GridViewAdapter adapter=new GridViewAdapter(getContext(),skillsData.getSkills());
        skillsGridView.setAdapter(adapter);
    }

    public void uploadPDF(View v) {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Files.getContentUri("external"));
        startActivityForResult(galleryIntent, 0);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == 0 && resultCode == RESULT_OK && null != data) {

                // Get the Image from data
                Uri selectedPDF = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};


                mediaPath = selectedPDF.getPath();

                // Set the Image in ImageView for Previewing the Media

            }
        } catch (Exception e) {

        }
    }

    public MediaStore.Images.Media getContentResolver() {
        return contentResolver;
    }

    public void setContentResolver(MediaStore.Images.Media contentResolver) {
        this.contentResolver = contentResolver;
    }
}