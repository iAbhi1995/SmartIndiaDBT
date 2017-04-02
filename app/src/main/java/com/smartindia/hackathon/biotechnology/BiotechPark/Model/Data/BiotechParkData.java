package com.smartindia.hackathon.biotechnology.BiotechPark.Model.Data;

/**
 * Created by ayush on 28-03-2017.
 */

public class BiotechParkData {
    private String biotechPark_name, biotechPark_location, biotechPark_state, biotechPark_city, biotechPark_address, biotechPark_website, biotechPark_descriptio;
    private String message;
    private boolean success;

    public BiotechParkData(String biotechPark_name, String biotechPark_location, String biotechPark_state, String biotechPark_city, String biotechPark_address, String biotechPark_website, String biotechPark_descriptio, String message, boolean success) {
        this.biotechPark_name = biotechPark_name;
        this.biotechPark_location = biotechPark_location;
        this.biotechPark_state = biotechPark_state;
        this.biotechPark_city = biotechPark_city;
        this.biotechPark_address = biotechPark_address;
        this.biotechPark_website = biotechPark_website;
        this.biotechPark_descriptio = biotechPark_descriptio;

        this.message = message;
        this.success = success;
    }


    public String getMessage() {
        return message;
    }
    public boolean isSuccess() {
        return success;
    }

    public String getBiotechPark_name() {
        return biotechPark_name;
    }

    public String getBiotechPark_location() {
        return biotechPark_location;
    }

    public String getBiotechPark_state() {
        return biotechPark_state;
    }

    public String getBiotechPark_city() {
        return biotechPark_city;
    }

    public String getBiotechPark_address() {
        return biotechPark_address;
    }

    public String getBiotechPark_website() {
        return biotechPark_website;
    }

    public String getBiotechPark_descriptio() {
        return biotechPark_descriptio;
    }
}
