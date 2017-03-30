package com.smartindia.hackathon.biotechnology.setInternship.model;

import android.os.Handler;
import android.util.Log;

import com.smartindia.hackathon.biotechnology.setInternship.SetInternshipCallBack;

/**
 * Created by aman on 30/3/17.
 */

public class MockSetInternship implements SetInternshipProvider {


    @Override
    public void requestIntern(String token, String company, String location, String date, String duration, String stipend, String applyBy, String aboutCompany, String aboutInternship, String no, String perk, String apply, SetInternshipCallBack setInternshipCallBack) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

               // SetInternshipCallBack.onSuccess(getmock());

                Log.d("Mock", "1");


            }
        }, 500);


    }






}
