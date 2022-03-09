package com.shanjiancaofu.effctiveJava.genertictype;

import java.util.ArrayList;
import java.util.List;

public class GenerticDemo {
    public static void main(String[] args) {

        List<String> list = new ArrayList();
        list.add(String.valueOf(1L));
        list.add("heloo");
        list.forEach(System.out::println);


    }
}
