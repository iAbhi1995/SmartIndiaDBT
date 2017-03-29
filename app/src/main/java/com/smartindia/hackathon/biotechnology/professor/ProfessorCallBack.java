package com.smartindia.hackathon.biotechnology.professor;

import com.smartindia.hackathon.biotechnology.professor.model.data.ProfessorData;

/**
 * Created by aman on 27/3/17.
 */

public interface ProfessorCallBack{

        void onSuccess(ProfessorData professorData);
        void onFailure();
}
