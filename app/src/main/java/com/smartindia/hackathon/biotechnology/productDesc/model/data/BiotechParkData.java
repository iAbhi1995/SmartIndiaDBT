package com.smartindia.hackathon.biotechnology.productDesc.model.data;

/**
 * Created by aman on 29/3/17.
 */

public class BiotechParkData {
    private String name;
    private String place;
    private String link;
    private String latitude;
    private String longitude;
    private String image;
    private String description;

    public BiotechParkData(String name, String place, String link, String latitude, String longitude, String image, String description) {
        this.name = name;
        this.place = place;
        this.link = link;
        this.latitude = latitude;
        this.longitude = longitude;
        this.image = image;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public String getLink() {
        return link;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }
}
