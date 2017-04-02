package com.smartindia.hackathon.biotechnology.profileView.Presenter;

import com.smartindia.hackathon.biotechnology.profileView.Model.Data.ProfileData;
import com.smartindia.hackathon.biotechnology.profileView.Model.ProfileProvider;
import com.smartindia.hackathon.biotechnology.profileView.ProfileCallback;
import com.smartindia.hackathon.biotechnology.profileView.View.ProfileView;

/**
 * Created by Abhishek on 02-04-2017.
 */

public class ProfilePresenterImpl implements ProfilePresenter {
    private ProfileView profileView;
    private ProfileProvider profileProvider;

    public ProfilePresenterImpl(ProfileView profileView, ProfileProvider profileProvider) {
        this.profileView = profileView;
        this.profileProvider = profileProvider;
    }

    @Override
    public void requestProfile(String access_token, String id) {
        profileView.showProgressBar(true);
        profileProvider.requestProfile(access_token, id, new ProfileCallback() {
            @Override
            public void onSuccess(ProfileData body) {
                if (body.isSuccess()) {
                    profileView.showProgressBar(false);
                    profileView.showProfile(body);


                } else {
                    profileView.showProgressBar(false);
                    profileView.showMessage(body.getMessage());
                }
            }

            @Override
            public void onFailure() {
                profileView.showProgressBar(false);
                profileView.showMessage("Something went wrong! Please try again");
            }
        });
    }
}
