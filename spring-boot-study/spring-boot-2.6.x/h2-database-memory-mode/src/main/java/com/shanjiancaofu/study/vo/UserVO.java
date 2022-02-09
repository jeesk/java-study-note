package com.shanjiancaofu.study.vo;

import com.shanjiancaofu.study.entity.User;
import lombok.Data;

@Data
public class UserVO {
    private Long id;
    private String name;
    private Integer age;

    private String email;

    public static UserVO convert(User user) {
        UserVO userVO = new UserVO();
        userVO.setId(user.getId());
        userVO.setAge(user.getAge());
        userVO.setEmail(user.getEmail());
        userVO.setName(user.getName());
        return userVO;
    }
}
