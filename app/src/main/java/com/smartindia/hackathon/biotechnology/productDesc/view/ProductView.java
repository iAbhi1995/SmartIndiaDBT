package com.smartindia.hackathon.biotechnology.productDesc.view;

import com.smartindia.hackathon.biotechnology.productDesc.model.data.ProductData;

/**
 * Created by aman on 29/3/17.
 */

public interface ProductView {


    void showMessage(String error);
    void onVerified(ProductData productData);
}
