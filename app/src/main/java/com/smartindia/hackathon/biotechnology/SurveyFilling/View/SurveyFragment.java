package com.smartindia.hackathon.biotechnology.SurveyFilling.View;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.smartindia.hackathon.biotechnology.R;
import com.smartindia.hackathon.biotechnology.SurveyFilling.Model.Data.SurveyData;
import com.smartindia.hackathon.biotechnology.SurveyFilling.Model.Data.SurveyResponse;
import com.smartindia.hackathon.biotechnology.SurveyFilling.Model.RetrofitSurveyProvider;
import com.smartindia.hackathon.biotechnology.SurveyFilling.Presenter.SurveyPresenter;
import com.smartindia.hackathon.biotechnology.SurveyFilling.Presenter.SurveyPresenterProvider;

public class SurveyFragment extends Fragment implements SurveyView {

    TextView title, description, ques1, ques2, ques3, ques4;
    EditText ans1, ans2, ans3, ans4;
    ProgressBar progressBar;
    String id, type, access_token;
    private SurveyPresenter surveyPresenter;

    public SurveyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_survey, container, false);
        title = (TextView) v.findViewById(R.id.title);
        description = (TextView) v.findViewById(R.id.description);
        ques1 = (TextView) v.findViewById(R.id.ques1);
        ques2 = (TextView) v.findViewById(R.id.ques2);
        ques3 = (TextView) v.findViewById(R.id.ques3);
        ques4 = (TextView) v.findViewById(R.id.ques4);
        progressBar = (ProgressBar) v.findViewById(R.id.progressbar);
        ans1 = (EditText) v.findViewById(R.id.ans1);
        ans2 = (EditText) v.findViewById(R.id.ans2);
        ans3 = (EditText) v.findViewById(R.id.ans3);
        ans4 = (EditText) v.findViewById(R.id.ans4);

        surveyPresenter = new SurveyPresenterProvider(new RetrofitSurveyProvider(), this);
        surveyPresenter.requestSurvey(id, type, access_token);
        return v;
    }

    @Override
    public void showLoading(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(getView().findViewById(R.id.relSurvey), message, Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }


    @Override
    public void onSurveyPosted(SurveyResponse surveyResponse) {
        Snackbar.make(getView().findViewById(R.id.relSurvey), "Survey Submitted Successfully,Thank you!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }

    @Override
    public void onSurveyReceived(SurveyData surveyData) {
        title.setText(surveyData.getTitle());
        description.setText(surveyData.getDescription());
        ques1.setText(surveyData.getQues1());
        ques2.setText(surveyData.getQues2());
        ques3.setText(surveyData.getQues3());
        ques4.setText(surveyData.getQues4());
        surveyPresenter.requestSurveyPost(id, type, access_token, ans1.getText().toString(), ans2.getText().toString(), ans3.getText().toString(), ans4.getText().toString());
    }
}