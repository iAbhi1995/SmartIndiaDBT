package com.smartindia.hackathon.biotechnology.professor.model.data;

/**
 * Created by aman on 31/3/17.
 */

public class InstitutionItemData {
    private String name,place,image,email,id;

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public String getImage() {
        return image;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public InstitutionItemData(String name, String place, String image, String email, String id) {

        this.name = name;
        this.place = place;
        this.image = image;
        this.email = email;
        this.id = id;
    }
}
