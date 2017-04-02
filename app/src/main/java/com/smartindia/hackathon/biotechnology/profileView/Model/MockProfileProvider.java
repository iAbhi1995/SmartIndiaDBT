package com.smartindia.hackathon.biotechnology.profileView.Model;

import android.os.Handler;

import com.smartindia.hackathon.biotechnology.profileView.Model.Data.ProfileData;
import com.smartindia.hackathon.biotechnology.profileView.ProfileCallback;

public class MockProfileProvider implements ProfileProvider {
    private ProfileData mockProfileData;

    @Override
    public void requestProfile(String access_token, String id, final ProfileCallback profileCallback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                profileCallback.onSuccess(getMockProfileData());
            }
        }, 500);
    }

    public ProfileData getMockProfileData() {
        mockProfileData = new ProfileData("Success", "Abhishek", "Lucknow", "NIT Raipur", "meabhi7@gmail.com", "B.Tech", "2019", "Microbial biology", "1.5 years experience in living science", "0", true);
        return mockProfileData;
    }
}
