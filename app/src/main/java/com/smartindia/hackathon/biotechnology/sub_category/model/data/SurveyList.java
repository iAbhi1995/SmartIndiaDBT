package com.smartindia.hackathon.biotechnology.sub_category.model.data;

/**
 * Created by iket on 1/4/17.
 */

public class SurveyList {
    String id,field,description,title;

    public SurveyList(String id, String field, String description, String title) {
        this.id = id;
        this.field = field;
        this.description = description;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getField() {
        return field;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }
}
