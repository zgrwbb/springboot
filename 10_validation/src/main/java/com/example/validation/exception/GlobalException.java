package com.example.validation.exception;

import com.example.validation.constant.BaseResultInfo;

/**
 * @author Created by wangbobo on 2018/7/20/15:48
 */
public class GlobalException extends Exception {
    private BaseResultInfo baseResultInfo;

    public GlobalException(BaseResultInfo baseResultInfo) {
        this.baseResultInfo = baseResultInfo;
    }

    public BaseResultInfo getBaseResultInfo() {
        return baseResultInfo;
    }

    public void setBaseResultInfo(BaseResultInfo baseResultInfo) {
        this.baseResultInfo = baseResultInfo;
    }
}
