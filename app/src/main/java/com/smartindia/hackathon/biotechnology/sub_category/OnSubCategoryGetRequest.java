package com.smartindia.hackathon.biotechnology.sub_category;


import com.smartindia.hackathon.biotechnology.sub_category.model.data.SubCategoryData;

public interface OnSubCategoryGetRequest {

    void onSuccess(SubCategoryData subCategoryData);
    void onFailure();

}
