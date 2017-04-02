package com.smartindia.hackathon.biotechnology.BiotechParkProduct.model.data;

/**
 * Created by ayush on 28-03-2017.
 */

public class BiotechParkData {
    String name,description,city,website;
    boolean success;

    public String getName() {
        return name;
    }
    public String getWebsite() {
        return website;
    }

    public String getDescription() {
        return description;
    }

    public String getCity() {
        return city;
    }

    public boolean isSuccess() {
        return success;
    }

    public BiotechParkData(String name, String description, String city,String website) {

        this.name = name;
        this.description = description;
        this.city = city;
        this.website = website;
    }
}
