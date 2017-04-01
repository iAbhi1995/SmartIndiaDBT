package com.smartindia.hackathon.biotechnology.productDesc.model;

import android.os.Handler;
import android.util.Log;

import com.smartindia.hackathon.biotechnology.productDesc.ProductCallBack;
import com.smartindia.hackathon.biotechnology.productDesc.model.data.BiotechParkData;
import com.smartindia.hackathon.biotechnology.productDesc.model.data.IncubatorsData;
import com.smartindia.hackathon.biotechnology.productDesc.model.data.InstitutionsData;
import com.smartindia.hackathon.biotechnology.productDesc.model.data.InsturmentData;
import com.smartindia.hackathon.biotechnology.productDesc.model.data.ProductData;
import com.smartindia.hackathon.biotechnology.productDesc.model.data.ProfileData;
import com.smartindia.hackathon.biotechnology.productDesc.model.data.ResearchPaperData;
import com.smartindia.hackathon.biotechnology.productDesc.model.data.SurveyData;
import com.smartindia.hackathon.biotechnology.professor.model.data.ProfessorCityData;

import com.smartindia.hackathon.biotechnology.professor.model.data.ProfessorData;
import com.smartindia.hackathon.biotechnology.professor.model.data.ProfessorItemData;
import com.smartindia.hackathon.biotechnology.professor.model.data.ProfessorTopicData;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by aman on 30/3/17.
 */

public class MockProduct implements ProductProvider {

    private String type,token,id;

    @Override
    public void requestProduct(String token, String type, String id,final ProductCallBack productCallBack) {

        this.type=type;
        this.token=token;
        this.id=id;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                productCallBack.onSuccess(getmock());

                Log.d("Mock", "1");


            }
        }, 500);
    }


    public ProductData getmock() {

        BiotechParkData biotechParkDatas = new BiotechParkData("", "", "", "", "", "","");
        IncubatorsData incubatorsDatas = new IncubatorsData("", "", "", "", "", "", "", "");
        InstitutionsData institutionsDatas = new InstitutionsData("", "", "", "", "", "", "", "", "");
        InsturmentData insturmentDatas = new InsturmentData("", "", "", "", "", "", "");
        ProfileData profileDatas = new ProfileData("", "", "", "", "", "", "", "", "");
        ResearchPaperData researchPaperDatas = new ResearchPaperData();
        SurveyData surveyDatas = new SurveyData("", "", "", "", "", "", "");

        ProductData productData = new ProductData(true, "Success", biotechParkDatas, incubatorsDatas,
                insturmentDatas, researchPaperDatas, profileDatas, surveyDatas);
        if(type.equals("3")) {
            biotechParkDatas = new BiotechParkData("", "", "", "", "", "","");
            incubatorsDatas = new IncubatorsData("a", "a", "a", "a", "a", "a", "a", "a");
            institutionsDatas = new InstitutionsData("", "", "", "", "", "", "", "", "");
            insturmentDatas = new InsturmentData("", "", "", "", "", "", "");
            profileDatas = new ProfileData("", "", "", "", "", "", "", "", "");
            researchPaperDatas = new ResearchPaperData();
            surveyDatas = new SurveyData("", "", "", "", "", "", "");

            productData = new ProductData(true, "Success", biotechParkDatas, incubatorsDatas,
                    insturmentDatas, researchPaperDatas, profileDatas, surveyDatas);
        }


        return productData;

    }
}