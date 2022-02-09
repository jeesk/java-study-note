package com.shanjiancaofu.exceptionhandle.web;

import com.shanjiancaofu.exceptionhandle.exception.ServiceException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping
public class TestExceptionController {

    /**
     * 全局ServiceException 异常拦截
     * @return
     * @throws ServiceException
     */
    @RequestMapping("testE")
    public Map<String, Object> testException() throws ServiceException {
        Map<String, Object> objectObjectHashMap = new HashMap<>();
        if (new Random().nextBoolean()) {
            throw new ServiceException(12, "xxx异常");
        }
        return objectObjectHashMap;
    }


    /**
     * spring boot 默认error 异常页面
     * src/main/resources/templates/ 下定义一个叫 error 的文件
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/exceptionMethod")
    public String exceptionMethod(Model model) throws Exception {
        model.addAttribute("msg", "没有抛出异常");
        int num = 1 / 0;   //a处
        return "home";
    }
}
