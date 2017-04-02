package com.smartindia.hackathon.biotechnology.Updates.View;

import com.smartindia.hackathon.biotechnology.Updates.Model.Data.UpdateData;

public interface UpdateView {
    void showProgressBar(boolean b);

    void showMessage(String s);

    void settingAdapter(UpdateData body);
}
