package com.smartindia.hackathon.biotechnology.insturmentUse.presenter;

import com.smartindia.hackathon.biotechnology.insturmentUse.model.InsturmentProvider;
import com.smartindia.hackathon.biotechnology.insturmentUse.view.InsturmentUseView;

/**
 * Created by aman on 30/3/17.
 */
public class InsturmentUsePresenterImpl implements InsturmentUsePresenter {

private InsturmentProvider insturmentProvider;
    private InsturmentUseView insturmentUseView;

    public InsturmentUsePresenterImpl(InsturmentProvider insturmentProvider, InsturmentUseView insturmentUseView) {
        this.insturmentProvider = insturmentProvider;
        this.insturmentUseView = insturmentUseView;
    }


    @Override
    public void requestInsturment(String id, String name, String email, String institute) {

    }
}
