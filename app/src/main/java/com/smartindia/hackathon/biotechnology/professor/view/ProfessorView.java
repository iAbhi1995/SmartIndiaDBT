package com.smartindia.hackathon.biotechnology.professor.view;

import com.smartindia.hackathon.biotechnology.Internship.model.data.InternshipData;
import com.smartindia.hackathon.biotechnology.professor.model.data.CityData;
import com.smartindia.hackathon.biotechnology.professor.model.data.ProfessorData;

/**
 * Created by aman on 27/3/17.
 */

public interface ProfessorView
{

    void showError(String message);

    //List-Spinners

    void showSpinnerCity(CityData professorData);

    void showSpinnerTopic(CityData professorData);
   // void check(ProfessorData professorData,String s);
    void check(ProfessorData professorData);

    void showProgressBar(boolean show);
    void setData(CityData cityData);








}
