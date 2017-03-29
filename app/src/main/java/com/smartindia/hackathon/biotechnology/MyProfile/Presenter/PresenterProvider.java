package com.smartindia.hackathon.biotechnology.MyProfile.Presenter;

import com.smartindia.hackathon.biotechnology.MyProfile.Model.Data.SkillsData;
import com.smartindia.hackathon.biotechnology.MyProfile.Model.MyProfileProvider;
import com.smartindia.hackathon.biotechnology.MyProfile.Model.SkillsProvider;
import com.smartindia.hackathon.biotechnology.MyProfile.SkillsCallback;
import com.smartindia.hackathon.biotechnology.MyProfile.view.MyProfileView;

/**
 * Created by Abhishek on 28-03-2017.
 */

public class PresenterProvider implements MyProfilePresenter {
    private SkillsProvider skillsProvider;
    private MyProfileView myProfileView;
    private MyProfileProvider myProfileProvider;

    public PresenterProvider(MyProfileView myProfileView, MyProfileProvider myProfileProvider) {
        this.myProfileView = myProfileView;
        this.myProfileProvider = myProfileProvider;
    }

    public PresenterProvider(MyProfileView myProfileView, SkillsProvider skillsProvider) {
        this.myProfileView = myProfileView;
        this.skillsProvider = skillsProvider;
    }

    @Override
    public void requestSkills() {
        myProfileView.showLoading(true);
        skillsProvider.requestSkills(new SkillsCallback() {
            @Override
            public void onSuccess(SkillsData skillsData) {
                if (skillsData.isSuccess()) {
                    myProfileView.onSkillsReceived(skillsData);
                    myProfileView.showLoading(false);
                } else {
                    myProfileView.showLoading(false);
                    myProfileView.showMessage("Error! Try Again");
                }
            }

            @Override
            public void onFailure() {
                myProfileView.showLoading(false);
                myProfileView.showMessage("Something went wrong!");
            }
        });
    }
    @Override
    public void requestMyProfile(String uid, String name, String college, String place, String emailId, String phoneNo) {

    }
}
