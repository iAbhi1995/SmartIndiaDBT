package com.smartindia.hackathon.biotechnology.insturmentUse;

import com.smartindia.hackathon.biotechnology.insturmentUse.model.data.InsturmentUseData;
import com.smartindia.hackathon.biotechnology.productDesc.model.data.InsturmentData;

/**
 * Created by aman on 30/3/17.
 */

public interface InsturmentUseCallBack {
    void OnSuccess(InsturmentUseData insturmentUseData);
    void OnFailure();
}
