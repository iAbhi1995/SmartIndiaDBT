package com.smartindia.hackathon.biotechnology.sub_category.model;


import com.smartindia.hackathon.biotechnology.sub_category.OnSubCategoryGetRequest;

public interface SubCategoryDetailsProvider {

    void requestSubCategoryDetails(String access_token,
                                   OnSubCategoryGetRequest onSubCategoryGetRequest);

}
