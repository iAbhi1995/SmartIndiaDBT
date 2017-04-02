package com.smartindia.hackathon.biotechnology.profileView.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.pkmmte.view.CircularImageView;
import com.smartindia.hackathon.biotechnology.R;
import com.smartindia.hackathon.biotechnology.profileView.Model.Data.ProfileData;
import com.smartindia.hackathon.biotechnology.profileView.Model.MockProfileProvider;
import com.smartindia.hackathon.biotechnology.profileView.Presenter.ProfilePresenter;
import com.smartindia.hackathon.biotechnology.profileView.Presenter.ProfilePresenterImpl;

public class Profile extends android.support.v4.app.Fragment implements ProfileView {


    CircularImageView circularImageView;
    TextView name, college, place, email, qualification, skills, experience, type, passing_year;
    private ProgressBar progressBar;
    private ProfilePresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile, container, false);
//        circularImageView=(CircularImageView)view.findViewById(R.id.my_profile_pic);
        name = (TextView) view.findViewById(R.id.user_profile_name);
        place = (TextView) view.findViewById(R.id.user_place);
        college = (TextView) view.findViewById(R.id.user_institution);
        email = (TextView) view.findViewById(R.id.user_email);
        qualification = (TextView) view.findViewById(R.id.user_qualification);
        skills = (TextView) view.findViewById(R.id.user_skills);
        experience = (TextView) view.findViewById(R.id.user_experience);
        type = (TextView) view.findViewById(R.id.user_type);
        passing_year = (TextView) view.findViewById(R.id.user_currentyear);

        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        presenter = new ProfilePresenterImpl(this, new MockProfileProvider());
        presenter.requestProfile("aaaa", "adas");
        return view;
    }

    @Override
    public void showProgressBar(boolean b) {
        if (b)
            progressBar.setVisibility(View.VISIBLE);
        else
            progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showMessage(String s) {
        Snackbar.make(getActivity().findViewById(R.id.RelativeLayout_profile), s, Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }

    @Override
    public void showProfile(ProfileData body) {
        name.setText(body.getName());
        place.setText(body.getPlace());
        college.setText(body.getCollege());
        email.setText(body.getEmail());
        qualification.setText(body.getQualification());
        passing_year.setText(body.getPassingYear());
        skills.setText(body.getSkills());
        experience.setText(body.getExperience());
        String userType;
        if (body.getType() == "1")
            userType = "Professor";
        else if (body.getType() == "0")
            userType = "Student";
        else if (body.getType() == "2")
            userType = "Institution";
        else
            userType = "Not Applicable";
        type.setText(userType);

    }
}