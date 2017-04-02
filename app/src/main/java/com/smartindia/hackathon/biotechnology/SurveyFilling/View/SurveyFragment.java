package com.smartindia.hackathon.biotechnology.SurveyFilling.View;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.smartindia.hackathon.biotechnology.R;
import com.smartindia.hackathon.biotechnology.SurveyFilling.Model.Data.SurveyData;
import com.smartindia.hackathon.biotechnology.SurveyFilling.Model.Data.SurveyResponse;
import com.smartindia.hackathon.biotechnology.SurveyFilling.Model.MockSurveyProvider;
import com.smartindia.hackathon.biotechnology.SurveyFilling.Model.RetrofitSurveyProvider;
import com.smartindia.hackathon.biotechnology.SurveyFilling.Presenter.SurveyPresenter;
import com.smartindia.hackathon.biotechnology.SurveyFilling.Presenter.SurveyPresenterProvider;

public class SurveyFragment extends Fragment implements SurveyView {

    TextView title, description, ques1, ques2, ques3, ques4;
    String ans1, ans2, ans3, ans4;
    ProgressBar progressBar;
    String id="1", type="1", access_token="sfs";
    private SurveyPresenter surveyPresenter;
    private Button submitButton;
    private RadioGroup ans1Grp,ans2Grp,ans3Grp,ans4Grp;

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
        submitButton=(Button)v.findViewById(R.id.submit);
        ans1Grp=(RadioGroup)v.findViewById(R.id.ans1_grp);
        ans2Grp=(RadioGroup)v.findViewById(R.id.ans2_grp);
        ans3Grp=(RadioGroup)v.findViewById(R.id.ans3_grp);
        ans4Grp=(RadioGroup)v.findViewById(R.id.ans4_grp);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitSurvey();
            }
        });
//        ans1 = (EditText) v.findViewById(R.id.ans1);
//        ans2 = (EditText) v.findViewById(R.id.ans2);
//        ans3 = (EditText) v.findViewById(R.id.ans3);
//        ans4 = (EditText) v.findViewById(R.id.ans4);
        surveyPresenter = new SurveyPresenterProvider(new RetrofitSurveyProvider(), this);
//        surveyPresenter = new SurveyPresenterProvider(new MockSurveyProvider(), this);

//        /

//        id token and type of survey is sent by calling fragment using bundle of setting it in shared prefs
//


//        surveyPresenter.requestSurvey(id, type, access_token);
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

    public void submitSurvey()
    {
        int id0=ans1Grp.getCheckedRadioButtonId();
        if(id0==R.id.ansYes1)
            ans1="Yes";
        else if(id0==R.id.ansNo1)
            ans1="No";
        else {
            Snackbar.make(getActivity().findViewById(R.id.relSurvey), "Please Select Answer1", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }
       int id1=ans2Grp.getCheckedRadioButtonId();
        if(id1==R.id.ansYes2)
            ans2="Yes";
        else if(id1==R.id.ansNo2)
            ans2="No";
        else{
            Snackbar.make(getActivity().findViewById(R.id.relSurvey),"Please Select Answer2",Snackbar.LENGTH_LONG).setAction("Action",null).show();
            return;}

        int id2=ans3Grp.getCheckedRadioButtonId();
        if(id2==R.id.ansYes3)
            ans3="Yes";
        else if(id2==R.id.ansNo3)
            ans3="No";
        else {
            Snackbar.make(getActivity().findViewById(R.id.relSurvey), "Please Select Answer3", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }


        int id3=ans4Grp.getCheckedRadioButtonId();
        if(id3==R.id.ansYes4)
            ans4="Yes";
        else if(id3==R.id.ansNo4)
            ans4="No";
        else {
            Snackbar.make(getActivity().findViewById(R.id.relSurvey), "Please Select Answer1", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }
        surveyPresenter.requestSurveyPost(id, type, access_token, ans1, ans2, ans3, ans4);
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
        ques1.setText("Question 1 : "+surveyData.getQues1());
        ques2.setText("Question 2 : "+surveyData.getQues2());
        ques3.setText("Question 3 : "+surveyData.getQues3());
        ques4.setText("Question 4 : "+surveyData.getQues4());
    }
}