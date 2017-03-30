package com.smartindia.hackathon.biotechnology.productDesc.presenter;

import com.smartindia.hackathon.biotechnology.productDesc.ProductCallBack;
import com.smartindia.hackathon.biotechnology.productDesc.model.ProductProvider;
import com.smartindia.hackathon.biotechnology.productDesc.model.data.ProductData;
import com.smartindia.hackathon.biotechnology.productDesc.view.ProductView;

/**
 * Created by aman on 29/3/17.
 */

public class ProductPresenterImpl implements ProductPresenter{


    private ProductProvider productProvider;
    private ProductView productView;


    public ProductPresenterImpl(ProductProvider productProvider, ProductView productView) {
        this.productProvider = productProvider;
        this.productView = productView;
    }

    @Override
    public void requestProduct(String token, String type, String id) {

        productProvider.requestProduct(token, type, id, new ProductCallBack() {
            @Override
            public void onSuccess(ProductData productData) {
                if(productData.isSuccess())
                {
                    productView.onVerified(productData);

                }
                else
                {

                    productView.showMessage(productData.getMessage());
                }
            }

            @Override
            public void onFailure() {


                productView.showMessage("NO INERNET CONNECTION");

            }
        });
    }
}
