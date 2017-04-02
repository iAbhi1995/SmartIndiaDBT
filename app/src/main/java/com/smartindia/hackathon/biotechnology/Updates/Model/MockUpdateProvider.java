package com.smartindia.hackathon.biotechnology.Updates.Model;


import android.os.Handler;
import android.util.Log;

import com.smartindia.hackathon.biotechnology.Updates.Model.Data.UpdateData;
import com.smartindia.hackathon.biotechnology.Updates.UpdateCallback;

import java.util.ArrayList;
import java.util.List;

public class MockUpdateProvider implements UpdateProvider {
    private UpdateData mockUpdateData;

    @Override
    public void requestUpdate(final UpdateCallback updateCallback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("abhi", "In the Mock");
                updateCallback.onSuccess(getMockUpdateData());
            }
        }, 500);
    }

    public UpdateData getMockUpdateData() {
        List<String> s = new ArrayList<>();
        s.add("Government of India today launched a schloarship for research fellows who want to work in the field of Living material science");
        s.add("Recently a survey done by DBT gave the fact that 40% of the diabetic patient are in the age group of 20-40");
        s.add("NIT Raipur Biotechnology Department has launched final call for all the applicants for the post of Clerk.");
        s.add("DBT launches a scheme for those interested in the research of bio organisms");
        s.add("Government of India today launched a schloarship for research fellows who want to work in the field of Living material science");
        s.add("Recently a survey done by DBT gave the fact that 40% of the diabetic patient are in the age group of 20-40");
        s.add("NIT Raipur Biotechnology Department has launched final call for all the applicants for the post of Clerk.");
        s.add("DBT launches a scheme for those interested in the research of bio organisms");
        s.add("Government of India today launched a schloarship for research fellows who want to work in the field of Living material science");
        s.add("Recently a survey done by DBT gave the fact that 40% of the diabetic patient are in the age group of 20-40");
        s.add("NIT Raipur Biotechnology Department has launched final call for all the applicants for the post of Clerk.");
        s.add("DBT launches a scheme for those interested in the research of bio organisms");
        mockUpdateData = new UpdateData("success", true, s);
        return mockUpdateData;
    }
}
