package com.smartindia.hackathon.biotechnology.applyInternship.Model;

import com.smartindia.hackathon.biotechnology.applyInternship.ApplyInternshipCallback;
import com.smartindia.hackathon.biotechnology.applyInternship.GetInternshipCallback;

/**
 * Created by Abhishek on 30-03-2017.
 */

public interface ApplyInternProvider {
    void getInternship(String id, String access_token, GetInternshipCallback getInternshipCallback);
    void applyInternship(String id, String access_token, ApplyInternshipCallback applyInternshipCallback);
}
