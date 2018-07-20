package com.example.validation.result;

import com.example.validation.constant.BaseResultInfo;
import com.example.validation.constant.GlobalInfoEnum;

/**
 * @author Created by wangbobo on 2018/7/20/15:58
 */
public class ResultBody {
    /**
     * 响应代码
     */
    private String code;
    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应结果
     */
    private Object result;

    public ResultBody(BaseResultInfo baseResultInfo) {
        this.code = baseResultInfo.getCode();
        this.message = baseResultInfo.getMessage();
    }

    public ResultBody(Object result) {
        this.code = GlobalInfoEnum.SUCCESS.getCode();
        this.message = GlobalInfoEnum.SUCCESS.getMessage();
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
