package com.smartindia.hackathon.biotechnology.professor.model.data;

/**
 * Created by aman on 1/4/17.
 */

public class FacilityItemData {
    private String name;
    private String place,image,institute,specification,id;

    public FacilityItemData(String name, String place, String image, String institute, String specification, String id) {
        this.name = name;
        this.place = place;
        this.image = image;
        this.institute = institute;
        this.specification = specification;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public String getImage() {
        return image;
    }

    public String getInstitute() {
        return institute;
    }

    public String getSpecification() {
        return specification;
    }

    public String getId() {
        return id;
    }
}
