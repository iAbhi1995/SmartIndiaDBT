package com.smartindia.hackathon.biotechnology.professor.presenter;

import android.util.Log;

import com.smartindia.hackathon.biotechnology.professor.CityCallBack;
import com.smartindia.hackathon.biotechnology.professor.ProfessorCallBack;
import com.smartindia.hackathon.biotechnology.professor.model.ProfessorProvider;

import com.smartindia.hackathon.biotechnology.professor.model.data.CityData;
import com.smartindia.hackathon.biotechnology.professor.model.data.ProfessorData;
import com.smartindia.hackathon.biotechnology.professor.view.ProfessorView;

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
                    professorView.check(professorData);//have to xheck
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

    @Override
    public void getCities(String type) {
        professorView.showProgressBar(true);
        Log.d("iket","presenter");
        professorProvider.requestCity(type, new CityCallBack() {
            @Override
            public void onSuccess(CityData cityData) {


                if(cityData.getSuccess()) {
                    Log.d("iket","success");
                    professorView.showProgressBar(false);
                    professorView.setData(cityData);
                }
                else {
                    Log.d("iket","fail");
                    professorView.showProgressBar(false);
                    professorView.showError(cityData.getMessage());
                }
            }

            @Override
            public void onFailure() {
                Log.d("iket","no internet");
                professorView.showProgressBar(false);
                professorView.showError("No internet access");
            }
        });
    }
}
