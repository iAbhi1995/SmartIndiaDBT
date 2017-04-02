package com.smartindia.hackathon.biotechnology.profileView.View;

import com.smartindia.hackathon.biotechnology.profileView.Model.Data.ProfileData;

/**
 * Created by Abhishek on 02-04-2017.
 */

public interface ProfileView {
    void showProgressBar(boolean b);

    void showMessage(String s);

    void showProfile(ProfileData body);
}
