package com.smartindia.hackathon.biotechnology.request.presenter;

import com.smartindia.hackathon.biotechnology.request.RequestCallBack;
import com.smartindia.hackathon.biotechnology.request.model.RequestProvider;
import com.smartindia.hackathon.biotechnology.request.model.data.RequestData;
import com.smartindia.hackathon.biotechnology.request.view.RequestView;

/**
 * Created by aman on 27/3/17.
 */

public class RequestPresenterImpl implements RequestPresenter {

private RequestProvider requestProvider;
    private RequestView requestView;




    public RequestPresenterImpl(RequestProvider requestProvider, RequestView requestView) {
        this.requestProvider = requestProvider;
        this.requestView = requestView;
    }




    @Override
    public void requestAppStatus(String token) {
        requestView.showProgressbar(true);
       requestProvider.requestAppStatus(token, new RequestCallBack() {

           @Override
           public void onSuccess(RequestData requestData) {
               if(requestData.isSuccess())
               {   requestView.dataReceive(requestData.getDataDetailsList());
                   requestView.showProgressbar(false);
               }
                   else
               {
                   requestView.showProgressbar(false);
                   requestView.showMessage(requestData.getMessage());
               }


           }

           @Override
           public void onFailure() {
                      requestView.showProgressbar(false);
               requestView.showMessage("UNABLE TO CONNECT ");
           }
       });
    }
}
