package com.smartindia.hackathon.biotechnology.profileView.Model;

import com.smartindia.hackathon.biotechnology.profileView.ProfileCallback;

/**
 * Created by Abhishek on 02-04-2017.
 */

public interface ProfileProvider {
    void requestProfile(String access_token, String id, ProfileCallback profileCallback);
}
