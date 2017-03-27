package com.smartindia.hackathon.biotechnology.Internship.model.data;

/**
 * Created by aman on 27/3/17.
 */

public class InternshipCityData {

    private String city;
    private String cityId;


    public InternshipCityData(String city, String cityId) {
        this.city = city;
        this.cityId = cityId;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }


}
