package com.smartindia.hackathon.biotechnology.sub_category.model.data;


public class Equipment_List {


    private String id,name,image, features, city,institute;

    public Equipment_List(String id, String name, String image, String features, String city, String institute) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.features = features;
        this.city = city;
        this.institute = institute;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getFeatures() {
        return features;
    }

    public String getCity() {
        return city;
    }

    public String getInstitute() {
        return institute;
    }
}


