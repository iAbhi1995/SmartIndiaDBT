package com.smartindia.hackathon.biotechnology.productDesc.model;

import com.smartindia.hackathon.biotechnology.productDesc.ProductCallBack;

/**
 * Created by aman on 29/3/17.
 */

public interface ProductProvider {


    void requestProduct(String token, String type, String id, ProductCallBack productCallBack);
}
