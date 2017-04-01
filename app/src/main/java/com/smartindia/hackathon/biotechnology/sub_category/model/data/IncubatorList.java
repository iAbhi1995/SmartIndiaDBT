package com.smartindia.hackathon.biotechnology.sub_category.model.data;

/**
 * Created by iket on 1/4/17.
 */

public class IncubatorList {
    String place,name,email,image,id;

    public IncubatorList(String place, String name, String email, String image, String id) {
        this.place = place;
        this.name = name;
        this.email = email;
        this.image = image;
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getImage() {
        return image;
    }

    public String getId() {
        return id;
    }
}
