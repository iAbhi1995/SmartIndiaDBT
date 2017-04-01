package com.smartindia.hackathon.biotechnology.sub_category.model.data;

import java.util.List;


public class    ProductListData {

    private boolean success;
    private String message;
    private List<Equipment_List> equipment_list;
    private List<IncubatorList> incubator_list;
    private List<UserList> user_list;
    private List<SurveyList> survey_list;

    public ProductListData(boolean success, String message, List<Equipment_List> equipment_list, List<IncubatorList> incubator_list,  List<UserList> user_list, List<SurveyList> survey_list) {
        this.success = success;
        this.message = message;
        this.equipment_list = equipment_list;
        this.incubator_list = incubator_list;
        this.user_list = user_list;
        this.survey_list = survey_list;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<Equipment_List> getEquipment_list() {
        return equipment_list;
    }

    public List<IncubatorList> getIncubator_list() {
        return incubator_list;
    }


    public List<UserList> getUser_list() {
        return user_list;
    }

    public List<SurveyList> getSurvey_list() {
        return survey_list;
    }
}
