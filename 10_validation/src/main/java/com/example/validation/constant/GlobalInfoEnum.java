package com.example.validation.constant;

/**
 * @author Created by wangbobo on 2018/7/20/15:35
 */
public enum GlobalInfoEnum implements BaseResultInfo {

//      枚举常量
//      默认继承GlobalErrorInfoEnum
//      SUCCESS 和 NOT_FOUND 相当于2个匿名类对象

     /**
     * 成功
     */
    SUCCESS("0","success"),
    NOT_FOUND("-1", "服务不存在");

    private String code;

    private String message;

    GlobalInfoEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode(){
        return this.code;
    }

    @Override
    public String getMessage(){
        return this.message;
    }
}
