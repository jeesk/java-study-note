package com.shanjiancaofu.study.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("test_user")
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
