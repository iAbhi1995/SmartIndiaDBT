package com.smartindia.hackathon.biotechnology.sub_category.view;

import java.util.List;

import com.smartindia.hackathon.biotechnology.sub_category.model.data.Equipment_List;
import com.smartindia.hackathon.biotechnology.sub_category.model.data.ProductListData;

/**
 * Created by aman on 28/3/17.
 */

public interface ProductListView {

    void showMessage(String message);
    void showProgressbar(boolean show);
    void setProductData(ProductListData productListData);
//    void loadData(String s);
}
