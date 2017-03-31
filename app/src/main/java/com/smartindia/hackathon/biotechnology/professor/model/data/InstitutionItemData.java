package com.smartindia.hackathon.biotechnology.professor.model.data;

/**
 * Created by aman on 31/3/17.
 */

public class InstitutionItemData {
    private String name,place,image,email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InstitutionItemData(String name, String place, String image, String email) {

        this.name = name;
        this.place = place;
        this.image = image;
        this.email = email;
    }
}
