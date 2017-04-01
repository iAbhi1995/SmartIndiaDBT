package com.smartindia.hackathon.biotechnology.insturmentUse.presenter;

import com.smartindia.hackathon.biotechnology.insturmentUse.InsturmentUseCallBack;
import com.smartindia.hackathon.biotechnology.insturmentUse.model.InsturmentProvider;
import com.smartindia.hackathon.biotechnology.insturmentUse.model.data.InsturmentUseData;
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
    public void requestInsturment(String id, String token, String name, String email, String phone, String institute) {
        insturmentUseView.showProgressBar(true);
        insturmentProvider.requestInsturment(id, token, name, email, phone, institute, new InsturmentUseCallBack() {
            @Override
            public void OnSuccess(InsturmentUseData insturmentUseData) {
                if(insturmentUseData.isSuccess())
                    insturmentUseView.showProgressBar(false);
                else{
                    insturmentUseView.showProgressBar(false);
                    insturmentUseView.showMessage(insturmentUseData.getMessage());
                }
            }

            @Override
            public void OnFailure() {
                insturmentUseView.showProgressBar(false);
                insturmentUseView.showMessage("UNABLE TO CONNECT");
            }
        });
    }

}
