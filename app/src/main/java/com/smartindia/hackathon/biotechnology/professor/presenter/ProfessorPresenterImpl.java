package com.smartindia.hackathon.biotechnology.Professor.Presenter;

import android.util.Log;

import com.smartindia.hackathon.biotechnology.Professor.ProfessorCallBack;
import com.smartindia.hackathon.biotechnology.Professor.Model.ProfessorProvider;

import com.smartindia.hackathon.biotechnology.Professor.Model.Data.ProfessorData;
import com.smartindia.hackathon.biotechnology.Professor.View.ProfessorView;

/**
 * Created by aman on 27/3/17.
 */

public class ProfessorPresenterImpl implements ProfessorPresenter {

    private ProfessorProvider professorProvider;
    private ProfessorView professorView;

    public ProfessorPresenterImpl(ProfessorProvider professorProvider, ProfessorView professorView) {
        this.professorProvider = professorProvider;
        this.professorView = professorView;
    }

    @Override
    public void requestProfessor(String token, String type,String city,String topic) {
        professorView.showProgressBar(true);
        professorProvider.requestProfessor(token, type,city,topic, new ProfessorCallBack() {
            @Override
            public void onSuccess(ProfessorData professorData) {
                if(professorData.isSuccess())
                {
                    Log.d("professorActivity",professorData.isSuccess()+"");
                    Log.d("professorActivity","2");
                    professorView.check(professorData);
                    professorView.showProgressBar(false);

                }
                else
                {
                    professorView.showProgressBar(false);
                    professorView.showError(professorData.getMessage());
                }
            }

            @Override
            public void onFailure() {

                professorView.showError("UNABLE TO CONNECT");
                professorView.showProgressBar(false);


            }
        });

    }
}
