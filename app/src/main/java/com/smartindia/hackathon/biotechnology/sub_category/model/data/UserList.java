package com.smartindia.hackathon.biotechnology.sub_category.model.data;

/**
 * Created by iket on 1/4/17.
 */

public class UserList {
    String name,location,email,description,image,id;

    public UserList(String name, String location, String email, String description, String image, String id) {
        this.name = name;
        this.location = location;
        this.email = email;
        this.description = description;
        this.image = image;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getId() {
        return id;
    }
}
