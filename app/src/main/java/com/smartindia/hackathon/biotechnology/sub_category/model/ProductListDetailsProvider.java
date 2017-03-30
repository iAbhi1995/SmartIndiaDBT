package com.smartindia.hackathon.biotechnology.sub_category.model;


import com.smartindia.hackathon.biotechnology.sub_category.OnProductListGetRequest;

public interface ProductListDetailsProvider {

void requestProductList(String query, String access_token, int subCategoryId, OnProductListGetRequest onProductListGetRequest);

}
