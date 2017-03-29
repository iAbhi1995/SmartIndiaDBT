package com.smartindia.hackathon.biotechnology.SurveyUpload.View;

import com.smartindia.hackathon.biotechnology.SurveyUpload.Model.Data.SureveyUploadData;

/**
 * Created by ayush on 28-03-2017.
 */

public interface OnSurveyUploadCallBack {
        void onSuccess(SureveyUploadData sureveyUploadData);
        void onFailure(String error);
}
