package com.smartindia.hackathon.biotechnology.professor.presenter;

import com.smartindia.hackathon.biotechnology.professor.ProfessorCallBack;
import com.smartindia.hackathon.biotechnology.professor.model.ProfessorProvider;
import com.smartindia.hackathon.biotechnology.professor.model.RetrofitProfessorProvider;
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
    public void requestProfessor(String token, String type) {
        professorProvider.requestProfessor(token, type, new ProfessorCallBack() {
            @Override
            public void onSuccess(ProfessorData professorData) {
                if(professorData.isSuccess())
                {
                    professorView.check(professorData);
                }
                else
                {
                    professorView.showError(professorData.getMessage());
                }
            }

            @Override
            public void onFailure() {

                professorView.showError("UNABLE TO CONNECT");



            }
        });

    }
}
