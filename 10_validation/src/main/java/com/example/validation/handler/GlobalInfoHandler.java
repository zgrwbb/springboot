package com.example.validation.handler;

import com.example.validation.constant.BaseResultInfo;
import com.example.validation.exception.GlobalException;
import com.example.validation.result.ResultBody;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Created by wangbobo on 2018/7/20/15:53
 */
@RestControllerAdvice
public class GlobalInfoHandler {
    @ExceptionHandler(value = GlobalException.class)
    public ResultBody errorHandlerOverJson(HttpServletRequest httpServletRequest, GlobalException globalException) {
        BaseResultInfo baseResultInfo = globalException.getBaseResultInfo();
        return new ResultBody(baseResultInfo);
    }
}
