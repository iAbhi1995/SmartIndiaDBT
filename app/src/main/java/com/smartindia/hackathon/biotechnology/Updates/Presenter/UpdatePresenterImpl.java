package com.smartindia.hackathon.biotechnology.Updates.Presenter;

import com.smartindia.hackathon.biotechnology.Updates.Model.Data.UpdateData;
import com.smartindia.hackathon.biotechnology.Updates.Model.UpdateProvider;
import com.smartindia.hackathon.biotechnology.Updates.UpdateCallback;
import com.smartindia.hackathon.biotechnology.Updates.View.UpdateView;

/**
 * Created by Abhishek on 02-04-2017.
 */

public class UpdatePresenterImpl implements UpdatePresenter {

    private UpdateView updateView;
    private UpdateProvider updateProvider;

    public UpdatePresenterImpl(UpdateView updateView, UpdateProvider updateProvider) {
        this.updateView = updateView;

        this.updateProvider = updateProvider;
    }

    @Override
    public void requestUpdate() {
        updateView.showProgressBar(true);
        updateProvider.requestUpdate(new UpdateCallback() {
            @Override
            public void onFailure() {
                updateView.showProgressBar(false);
                updateView.showMessage("Something went wrong!Please try again");
            }

            @Override
            public void onSuccess(UpdateData body) {
                if (body.isSuccess()) {
                    updateView.showProgressBar(false);
                    updateView.settingAdapter(body);
                } else {
                    updateView.showProgressBar(false);
                    updateView.showMessage(body.getMessage());
                }
            }
        });

    }
}
