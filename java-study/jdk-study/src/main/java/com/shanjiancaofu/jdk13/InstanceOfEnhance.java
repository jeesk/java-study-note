package com.shanjiancaofu.jdk13;

public class InstanceOfEnhance {
    public static void main(String[] args) {
        // 自动模式匹配
        class Stu {
            public final int code = 1;

        }
        Object stu = new Stu();
        // 自动模式转换
        if (stu instanceof Stu s) {
            System.out.println(s.code);
        }
    }
}
