package com.smartindia.hackathon.biotechnology.Professor.Model.Data;

/**
 * Created by aman on 27/3/17.
 */

public class ProfessorCityData {
    private String city;
    private String cityId;

    public String getCity() {
        return city;
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

    public ProfessorCityData(String city, String cityId) {

        this.city = city;
        this.cityId = cityId;
    }
}
