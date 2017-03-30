package com.smartindia.hackathon.biotechnology.productDesc;

import com.smartindia.hackathon.biotechnology.productDesc.model.data.ProductData;

/**
 * Created by aman on 29/3/17.
 */

public interface ProductCallBack {

void onSuccess(ProductData productData);
    void onFailure();

}
