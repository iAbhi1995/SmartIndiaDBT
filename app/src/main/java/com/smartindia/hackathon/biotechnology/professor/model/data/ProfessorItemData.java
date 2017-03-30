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
    private String image,id;

    public ProfessorItemData(String one, String two, String three, String four, String image, String id) {
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
        this.image = image;
        this.id = id;
    }

    public String getOne() {
        return one;
    }

    public String getTwo() {
        return two;
    }

    public String getThree() {
        return three;
    }

    public String getFour() {
        return four;
    }

    public String getImage() {
        return image;
    }

    public String getId() {
        return id;
    }
}
