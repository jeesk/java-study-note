package com.shanjiancaofu.effctiveJava;

import org.junit.Test;

import java.util.UUID;

public class StringTest {


    @Test
    public void stringUtil() {

        try {
            System.out.println(1);
        } catch (Exception e) {
            System.out.println(2);
        } finally {
            System.out.println(3);
        }

        System.out.println(4);

    }


    public void continueTest(int i) {

        if (i == 3 || i == 7) {

        }

    }

    @Test
    public void testUUId() {
        String s = UUID.randomUUID().toString();
        System.out.println(s);
    }
}
