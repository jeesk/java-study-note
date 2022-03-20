package com.shanjiancaofu.effctiveJava.genertictype;

/**
 * @Description
 * @Author 宋奇福 <meetsong@foxmail.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2018/9/9 16:00
 */

public class Student extends Person {
    public String getZhaoliu() {
        return zhaoliu;
    }
    public Student (){

    }

    public Student(String zhaoliu, int age, int number) {
        this.zhaoliu = zhaoliu;
        this.age = age;
        this.number = number;
    }

    public void setZhaoliu(String zhaoliu) {
        this.zhaoliu = zhaoliu;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private String zhaoliu;
    private int age;
    private int number;
}
