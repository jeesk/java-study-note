package com.shanjiancaofu.effctiveJava.genertictype;

import java.io.Serializable;



public class Person implements Serializable {


    private String zhaoliu;
    private int age;
    private int number;

    public String getZhaoliu() {
        return zhaoliu;
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

    public Person(String zhaoliu, int age, int number) {
        this.zhaoliu = zhaoliu;
        this.age = age;
        this.number = number;
    }

    public Person(){}
}
