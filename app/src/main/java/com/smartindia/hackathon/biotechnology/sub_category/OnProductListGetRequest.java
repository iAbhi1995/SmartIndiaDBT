package com.smartindia.hackathon.biotechnology.sub_category;


import com.smartindia.hackathon.biotechnology.sub_category.model.data.ProductListData;

public interface OnProductListGetRequest {

    void onSuccess(ProductListData productListData);
    void onFailure();

}
