package com.smartindia.hackathon.biotechnology.professor.model;

import android.os.Handler;
import android.util.Log;

import com.smartindia.hackathon.biotechnology.professor.ProfessorCallBack;
import com.smartindia.hackathon.biotechnology.professor.model.data.ProfessorCityData;

import com.smartindia.hackathon.biotechnology.professor.model.data.ProfessorData;
import com.smartindia.hackathon.biotechnology.professor.model.data.ProfessorItemData;
import com.smartindia.hackathon.biotechnology.professor.model.data.ProfessorTopicData;

import java.util.ArrayList;
import java.util.List;

public class MockProfessorProvider implements ProfessorProvider {

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
        List<ProfessorTopicData> professorTopicDatas = new ArrayList<>();
        List<ProfessorItemData> professorItemDatas = new ArrayList<>();

        if(!city.equals("aman"))
        {
            for (int i =0; i < 5; i++) {
                ProfessorCityData professorCityData = new ProfessorCityData("aman",i + "");
                professorCityDatas.add(professorCityData);

                ProfessorTopicData professorTopicData = new ProfessorTopicData("aman",i + "");
                professorTopicDatas.add(professorTopicData);
                ProfessorItemData professorItemData = new ProfessorItemData("aman",i + "","aman2","aman3","aman4","aman5");
                professorItemDatas.add(professorItemData);
            }
        }
        else
        {
            for (int i =0; i < 5; i++) {
                ProfessorCityData professorCityData = new ProfessorCityData("ag"+i,i + "");
                professorCityDatas.add(professorCityData);

                ProfessorTopicData professorTopicData = new ProfessorTopicData("aj"+i,i + "");
                professorTopicDatas.add(professorTopicData);
                ProfessorItemData professorItemData = new ProfessorItemData("aj"+i,i + "","aman2","aman3","aman4","aman5");
                professorItemDatas.add(professorItemData);
            }

        }


       ProfessorData professorData=new ProfessorData(true,"success",professorCityDatas,
               professorTopicDatas,professorItemDatas);
        return professorData;
    }

}



