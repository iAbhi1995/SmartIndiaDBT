package com.smartindia.hackathon.biotechnology.Updates;

import com.smartindia.hackathon.biotechnology.Updates.Model.Data.UpdateData;

public interface UpdateCallback {
    void onFailure();

    void onSuccess(UpdateData body);
}
