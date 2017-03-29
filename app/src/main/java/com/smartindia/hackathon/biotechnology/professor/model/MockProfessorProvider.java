package com.smartindia.hackathon.biotechnology.Professor.Model;

import android.os.Handler;
import android.util.Log;

import com.smartindia.hackathon.biotechnology.Professor.ProfessorCallBack;
import com.smartindia.hackathon.biotechnology.Professor.Model.Data.ProfessorCityData;
import com.smartindia.hackathon.biotechnology.Professor.Model.Data.ProfessorCollegeData;
import com.smartindia.hackathon.biotechnology.Professor.Model.Data.ProfessorData;
import com.smartindia.hackathon.biotechnology.Professor.Model.Data.ProfessorItemData;
import com.smartindia.hackathon.biotechnology.Professor.Model.Data.ProfessorTopicData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 28/3/17.
 */

public class MockProfessorProvider implements com.smartindia.hackathon.biotechnology.Professor.Model.ProfessorProvider {

    public String city;
    @Override
    public void requestProfessor(String token, String type, String city, String topic, final ProfessorCallBack professorCallBack) {

            this.city = city;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                professorCallBack.onSuccess(getmockProfessor());

                Log.d("Mock", "1");


            }
        }, 500);
    }

    public ProfessorData getmockProfessor() {
        List<ProfessorCityData> professorCityDatas = new ArrayList<>();
        List<ProfessorCollegeData> professorCollegeDatas = new ArrayList<>();
        List<ProfessorTopicData> professorTopicDatas = new ArrayList<>();
        List<ProfessorItemData> professorItemDatas = new ArrayList<>();

        if(!city.equals("aman"))
        {
            for (int i =0; i < 5; i++) {
                ProfessorCityData professorCityData = new ProfessorCityData("aman",i + "");
                professorCityDatas.add(professorCityData);
                ProfessorCollegeData professorCollegeData = new ProfessorCollegeData("aman",i + "");
                professorCollegeDatas.add(professorCollegeData);
                ProfessorTopicData professorTopicData = new ProfessorTopicData("aman",i + "");
                professorTopicDatas.add(professorTopicData);
                ProfessorItemData professorItemData = new ProfessorItemData("aman",i + "","aman2","aman3","aman4");
                professorItemDatas.add(professorItemData);
            }
        }
        else
        {
            for (int i =0; i < 5; i++) {
                ProfessorCityData professorCityData = new ProfessorCityData("ag"+i,i + "");
                professorCityDatas.add(professorCityData);
                ProfessorCollegeData professorCollegeData = new ProfessorCollegeData("ag"+i,i + "");
                professorCollegeDatas.add(professorCollegeData);
                ProfessorTopicData professorTopicData = new ProfessorTopicData("aj"+i,i + "");
                professorTopicDatas.add(professorTopicData);
                ProfessorItemData professorItemData = new ProfessorItemData("aj"+i,i + "","aman2","aman3","aman4");
                professorItemDatas.add(professorItemData);
            }

        }


        ProfessorData professorData=new ProfessorData(true,"success",professorCityDatas,professorCollegeDatas,
                professorTopicDatas,professorItemDatas);
        return professorData;
    }

}



