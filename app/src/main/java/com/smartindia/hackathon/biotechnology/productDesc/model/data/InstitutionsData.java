package com.smartindia.hackathon.biotechnology.productDesc.model.data;

/**
 * Created by aman on 29/3/17.
 */

public class InstitutionsData {
    private String name;
    private String place;
    private String link;
    private String labFacilities;
    private String details;
    private String courseOffered;
    private String xCordinate;
    private String yCordinate;
    private String image;

    public InstitutionsData(String name,
                            String place,
                            String link,
                            String labFacilities,
                            String details,
                            String courseOffered, String xCordinate, String yCordinate, String image) {
        this.name = name;
        this.place = place;
        this.link = link;
        this.labFacilities = labFacilities;
        this.details = details;
        this.courseOffered = courseOffered;
        this.xCordinate = xCordinate;
        this.yCordinate = yCordinate;
        this.image = image;
    }

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLabFacilities() {
        return labFacilities;
    }

    public void setLabFacilities(String labFacilities) {
        this.labFacilities = labFacilities;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCourseOffered() {
        return courseOffered;
    }

    public void setCourseOffered(String courseOffered) {
        this.courseOffered = courseOffered;
    }

    public String getxCordinate() {
        return xCordinate;
    }

    public void setxCordinate(String xCordinate) {
        this.xCordinate = xCordinate;
    }

    public String getyCordinate() {
        return yCordinate;
    }

    public void setyCordinate(String yCordinate) {
        this.yCordinate = yCordinate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
