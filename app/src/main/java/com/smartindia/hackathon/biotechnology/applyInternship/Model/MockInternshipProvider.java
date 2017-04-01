package com.smartindia.hackathon.biotechnology.applyInternship.Model;

import android.os.Handler;

import com.smartindia.hackathon.biotechnology.applyInternship.ApplyInternshipCallback;
import com.smartindia.hackathon.biotechnology.applyInternship.GetInternshipCallback;
import com.smartindia.hackathon.biotechnology.applyInternship.Model.Data.ApplyInternData;
import com.smartindia.hackathon.biotechnology.applyInternship.Model.Data.GetInternshipData;
import com.smartindia.hackathon.biotechnology.applyInternship.Presenter.ApplyInternPresenter;


public class MockInternshipProvider implements ApplyInternProvider {
    private GetInternshipData mockInternData;
    private ApplyInternData mockApplyInternData;

    @Override
    public void getInternship(String id, String access_token, final GetInternshipCallback getInternshipCallback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getInternshipCallback.onSuccess(getMockInternData());
            }
        }, 500);
    }

    @Override
    public void applyInternship(String id, String access_token, final ApplyInternshipCallback applyInternshipCallback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                applyInternshipCallback.onSuccess(getMockApplyInternData());
            }
        }, 500);
    }


    public GetInternshipData getMockInternData() {
        mockInternData=new GetInternshipData("Success","Living Organic Research","Related to Living Organism","Lucknow",
                "2nd May","6 months","Rs.5000 /month","30th April","Only those candidates who are currently pursuing under graduate or post graduate course.","Certificate,Letter of Recommendation,formal dress code","A101A",
                "The selected researcher willl work with our team",true);
        return mockInternData;
    }

    public ApplyInternData getMockApplyInternData() {
        mockApplyInternData=new ApplyInternData("Success",true);
        return mockApplyInternData;
    }
}
