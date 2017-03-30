package com.smartindia.hackathon.biotechnology.sub_category.view;

import com.smartindia.hackathon.biotechnology.sub_category.model.data.SubCategoryData;

/**
 * Created by aman on 28/3/17.
 */

public interface SubCategoryView {

    void showProgressBar(boolean show);
    void showMessage(String message);
    void setTabs(SubCategoryData subCategoryData);
}
