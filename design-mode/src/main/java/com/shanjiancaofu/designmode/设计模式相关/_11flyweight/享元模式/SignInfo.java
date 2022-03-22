package com.shanjiancaofu.designmode.设计模式相关._11flyweight.享元模式;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignInfo {
    //报名人员的ID
    private String id;
    //考试地点
    private String location;
    //考试科目
    private String subject;
    //邮寄地址
    private String postAddress;


}
