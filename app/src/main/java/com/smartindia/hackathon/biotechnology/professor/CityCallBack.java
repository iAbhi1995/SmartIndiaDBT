package com.smartindia.hackathon.biotechnology.professor;

import com.smartindia.hackathon.biotechnology.professor.model.data.CityData;
import com.smartindia.hackathon.biotechnology.professor.model.data.ProfessorData;

/**
 * Created by iket on 2/4/17.
 */

public interface CityCallBack {

    void onSuccess(CityData cityData);
    void onFailure();
}
