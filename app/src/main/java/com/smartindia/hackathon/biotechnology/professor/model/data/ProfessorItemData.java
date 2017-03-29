package com.smartindia.hackathon.biotechnology.professor.model.data;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by aman on 28/3/17.
 */

public class ProfessorItemData {

    private String one ;
    private String two ;
    private  String three;
    private String four;
    private String image;

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }

    public String getThree() {
        return three;
    }

    public void setThree(String three) {
        this.three = three;
    }

    public String getFour() {
        return four;
    }

    public void setFour(String four) {
        this.four = four;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ProfessorItemData(String one, String two, String three, String four, String image) {

        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
        this.image = image;
    }
}
