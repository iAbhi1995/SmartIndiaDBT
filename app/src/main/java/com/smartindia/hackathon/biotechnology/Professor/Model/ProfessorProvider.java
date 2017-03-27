package com.smartindia.hackathon.biotechnology.professor.model;

import com.smartindia.hackathon.biotechnology.professor.ProfessorCallBack;

/**
 * Created by aman on 27/3/17.
 */

public interface ProfessorProvider  {

    void requestProfessor(String token, String type, ProfessorCallBack professorCallBack);
}
