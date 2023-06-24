package com.shanjiancaofu.java11;

public interface Printer {
    String print(String str);
}


class Demo {
    public static void main(String[] args) {
        Printer pr = (String str) -> {
            System.out.println(str);
            return str;
        };
        // 简化了lambda 的推断
        Printer pr1 = a -> a;
    }
}
