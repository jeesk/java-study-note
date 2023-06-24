package com.shanjiancaofu.jdk13;

public class SwitchEnhance {
    public static void main(String[] args) {
        var str = "1";
        // 获取返回值
        var result = switch (str) {
            case "1" -> "hello";
            case "2" -> "wordl";
            default -> "not";
        };
        System.out.println(result);
    }
}
