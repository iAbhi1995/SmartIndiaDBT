package com.smartindia.hackathon.biotechnology.instrument.model.data;

/**
 * Created by aman on 2/4/17.
 */

public class InstrumentData {
    String name,available,details,application,latitude,longitude,image,id,message;
    boolean success;

    public String getName() {
        return name;
    }

    public String getAvailable() {
        return available;
    }

    public String getDetails() {
        return details;
    }

    public String getApplication() {
        return application;
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

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public InstrumentData(String name, String available, String details, String application, String latitude, String longitude, String image, String id, String message, boolean success) {

        this.name = name;
        this.available = available;
        this.details = details;
        this.application = application;
        this.latitude = latitude;
        this.longitude = longitude;
        this.image = image;
        this.id = id;
        this.message = message;
        this.success = success;
    }
}
