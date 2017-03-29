package com.smartindia.hackathon.biotechnology.SurveyUpload.Presenter;

import android.net.Uri;

/**
 * Created by ayush on 28-03-2017.
 */

public interface SurveyUploadPresenter {
        void requestUpload(Uri uri, String survey_title, String survey_scale, String survey_description, String survey_question1, String survey_question2, String survey_question3, String survey_question4);
}
