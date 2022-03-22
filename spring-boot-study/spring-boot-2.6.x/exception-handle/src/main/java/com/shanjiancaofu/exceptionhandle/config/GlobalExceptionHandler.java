package com.shanjiancaofu.exceptionhandle.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shanjiancaofu.exceptionhandle.exception.ServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * 定义全局异常
 * ControllerAdvice 的basePackages 和basePackageClasses 可以指定异常范围的包和class
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 业务异常
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public Object serviceException(HttpServletRequest request, ServiceException e) throws JsonProcessingException {
        HashMap<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("code", e.getCode());
        errorResponse.put("msg", e.getMsg());
        return new ObjectMapper().writeValueAsString(errorResponse);
    }

}