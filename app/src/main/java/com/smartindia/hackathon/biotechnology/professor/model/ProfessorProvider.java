package com.smartindia.hackathon.biotechnology.Professor.Model;

import com.smartindia.hackathon.biotechnology.Professor.ProfessorCallBack;

/**
 * Created by aman on 28/3/17.
 */

public interface ProfessorProvider {



        void requestProfessor(String token, String type,String city,String topic, ProfessorCallBack professorCallBack);





}
