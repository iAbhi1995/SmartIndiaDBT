package com.smartindia.hackathon.biotechnology.sub_category.view;

import java.util.List;

import com.smartindia.hackathon.biotechnology.sub_category.model.data.ProductListDetails;

/**
 * Created by aman on 28/3/17.
 */

public interface ProductListView {

    void showMessage(String message);
    void showProgressbar(boolean show);
    void setProductData(List<ProductListDetails> productListDetails);
//    void loadData(String s);
}
