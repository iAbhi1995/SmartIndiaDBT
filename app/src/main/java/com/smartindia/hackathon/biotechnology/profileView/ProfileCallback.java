package com.smartindia.hackathon.biotechnology.profileView;

import com.smartindia.hackathon.biotechnology.profileView.Model.Data.ProfileData;

public interface ProfileCallback {
    void onSuccess(ProfileData body);

    void onFailure();
}
