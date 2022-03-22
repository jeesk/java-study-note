spring boot 的异常处理

#### 1. 全局异常处理

```java
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
```

#### 2. 指定某个controller的异常处理

package com.shanjiancaofu.exceptionhandle.web;

import com.fasterxml.jackson.core.JsonProcessingException; import com.fasterxml.jackson.databind.ObjectMapper; import
org.springframework.ui.Model; import org.springframework.web.bind.annotation.ExceptionHandler; import
org.springframework.web.bind.annotation.RequestMapping; import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest; import java.util.HashMap;

@RestController public class CurrentExceptionController {

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

#### 3. 指定404,500 异常页面
在 resource/public/error 放入404.html,500.html即可