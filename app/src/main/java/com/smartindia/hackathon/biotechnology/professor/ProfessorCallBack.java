package com.smartindia.hackathon.biotechnology.Professor;

import com.smartindia.hackathon.biotechnology.Professor.Model.Data.ProfessorData;

/**
 * Created by aman on 27/3/17.
 */

public interface ProfessorCallBack{

        void onSuccess(ProfessorData professorData);
        void onFailure();
}
