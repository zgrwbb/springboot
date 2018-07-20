package com.example.validation.constant;

/**
 * @author Created by wangbobo on 2018/7/20/11:38
 */
public interface BaseResultInfo {
    /**
     * 获取错误码
     * @return errorCode
     */
    String getCode();

    /**
     * 获取错误信息
     * @return 错误信息
     */
    String getMessage();
}
