package com.smartindia.hackathon.biotechnology.professor.presenter;

import com.smartindia.hackathon.biotechnology.professor.ProfessorCallBack;

/**
 * Created by aman on 27/3/17.
 */

public interface ProfessorPresenter {


    void requestProfessor(String token, String type,String city,String topic);
    void getCities(String type);



}
