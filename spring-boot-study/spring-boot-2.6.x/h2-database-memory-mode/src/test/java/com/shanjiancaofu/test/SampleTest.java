package com.shanjiancaofu.test;


import com.shanjiancaofu.study.H2DatabaseInMomoryApplication;
import com.shanjiancaofu.study.entity.User;
import com.shanjiancaofu.study.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest(classes = H2DatabaseInMomoryApplication.class)
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.isTrue(5 == userList.size(), "成功");
        userList.forEach(System.out::println);
    }
}
