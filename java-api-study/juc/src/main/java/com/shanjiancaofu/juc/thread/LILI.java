package com.shanjiancaofu.juc.thread;

import org.junit.Test;

/**
 * @Description
 * @Author 宋奇福 <meetsong@foxmail.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2018/9/10 2:15
 */
public class LILI {


    @Test
    public void testDemo() {

        String str = "13abf";

        int len = str.length();
        int sum = 0;
        for (int i = 0; i < len; i++) {

            char c = str.charAt(len - 1 - i);// 从最后一位取到第0位

            int n = Character.digit(c, 16);
            int x = 1 << (4 * i);
            int y = 16 << i;

            System.out.println(y+"=y"+"__"+x+"=x");
            System.out.println();
            sum += n * (x);
            //  			/*
            // 			 * 这就相当于1*16^4+3*16^3+...
            // 			 * <<:高位去除，地位补0
            // 			 * a<<b在数据不溢出的情况下相当于a*2^b
            // 			 */

        }
        System.out.println(sum);
        System.out.println(Integer.parseInt(str, 16));

    }

    @Test
    public void test() {
        int c = Character.digit('c', 16);
        System.out.println(c);
        System.out.println(Integer.parseInt("c", 16));


    }


}
