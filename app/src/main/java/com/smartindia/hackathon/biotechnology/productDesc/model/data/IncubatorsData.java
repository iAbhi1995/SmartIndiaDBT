package com.smartindia.hackathon.biotechnology.productDesc.model.data;

/**
 * Created by aman on 29/3/17.
 */

public class IncubatorsData {

    private String incubator_name,incubator_thrustArea,incubator_state,incubator_city,incubator_address,incubator_website,incubator_person
            ,incubator_contact;


    public IncubatorsData(String incubator_name, String incubator_thrustArea, String incubator_state, String incubator_city, String incubator_address,
                          String incubator_website, String incubator_person, String incubator_contact) {
        this.incubator_name = incubator_name;
        this.incubator_thrustArea = incubator_thrustArea;
        this.incubator_state = incubator_state;
        this.incubator_city = incubator_city;
        this.incubator_address = incubator_address;
        this.incubator_website = incubator_website;
        this.incubator_person = incubator_person;
        this.incubator_contact = incubator_contact;
    }

    public String getIncubator_name() {
        return incubator_name;
    }

    public void setIncubator_name(String incubator_name) {
        this.incubator_name = incubator_name;
    }

    public String getIncubator_thrustArea() {
        return incubator_thrustArea;
    }

    public void setIncubator_thrustArea(String incubator_thrustArea) {
        this.incubator_thrustArea = incubator_thrustArea;
    }

    public String getIncubator_state() {
        return incubator_state;
    }

    public void setIncubator_state(String incubator_state) {
        this.incubator_state = incubator_state;
    }

    public String getIncubator_city() {
        return incubator_city;
    }

    public void setIncubator_city(String incubator_city) {
        this.incubator_city = incubator_city;
    }

    public String getIncubator_address() {
        return incubator_address;
    }

    public void setIncubator_address(String incubator_address) {
        this.incubator_address = incubator_address;
    }

    public String getIncubator_website() {
        return incubator_website;
    }

    public void setIncubator_website(String incubator_website) {
        this.incubator_website = incubator_website;
    }

    public String getIncubator_person() {
        return incubator_person;
    }

    public void setIncubator_person(String incubator_person) {
        this.incubator_person = incubator_person;
    }

    public String getIncubator_contact() {
        return incubator_contact;
    }

    public void setIncubator_contact(String incubator_contact) {
        this.incubator_contact = incubator_contact;
    }
}
