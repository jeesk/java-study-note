package com.shanjiancaofu.study.web;

import com.shanjiancaofu.study.entity.User;
import com.shanjiancaofu.study.mapper.UserMapper;
import com.shanjiancaofu.study.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.h2.H2ConsoleProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/{id}")
    public UserVO findById(@PathVariable("id") Long id) {
        User user = userMapper.selectById(id);
        return UserVO.convert(user);
    }
}
