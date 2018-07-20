package com.example.validation.constant;

/**
 * @author Created by wangbobo on 2018/7/20/11:37
 */
public enum CityInfoEnum implements BaseResultInfo {
    /**
     * 000001 缺少参数
     */
    MISSING_PARAMETER("000001","缺少参数"),
    CITY_ALREADY_EXISTS("000002","已经存在");

    private String code;
    private String message;

    CityInfoEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
