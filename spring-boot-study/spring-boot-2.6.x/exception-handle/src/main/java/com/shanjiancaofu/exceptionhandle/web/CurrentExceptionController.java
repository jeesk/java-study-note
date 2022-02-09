package com.shanjiancaofu.exceptionhandle.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
public class CurrentExceptionController {


    /**
     * 当前的handleCustomException 只能处理本controller的异常
     *
     * @param request
     * @param ex
     * @return
     * @throws JsonProcessingException
     */
    @ExceptionHandler(Exception.class)
    String handleCustomException(HttpServletRequest request, Exception ex) throws JsonProcessingException {
        HashMap<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("msg", ex.getMessage());
        return new ObjectMapper().writeValueAsString(errorResponse);
    }


    @RequestMapping("/CurrentExceptionController")
    public HashMap<String, Object> getUser() throws Exception {
        HashMap<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("name", "xiaoming");
        errorResponse.put("id", 12);
        int num = 1 / 0;   //a处
        return errorResponse;
    }


}
