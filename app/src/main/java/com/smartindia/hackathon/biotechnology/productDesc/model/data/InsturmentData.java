package com.smartindia.hackathon.biotechnology.productDesc.model.data;

/**
 * Created by aman on 29/3/17.
 */

public class InsturmentData {

    private String name;
    private String description;
    private String use;
    private String features;
    private String institutionAvailable;
    private String image;
    private String id;

    public InsturmentData(String name, String description, String use, String features,
                          String institutionAvailable, String image, String id) {
        this.name = name;
        this.description = description;
        this.use = use;
        this.features = features;
        this.institutionAvailable = institutionAvailable;
        this.image = image;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getInstitutionAvailable() {
        return institutionAvailable;
    }

    public void setInstitutionAvailable(String institutionAvailable) {
        this.institutionAvailable = institutionAvailable;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
