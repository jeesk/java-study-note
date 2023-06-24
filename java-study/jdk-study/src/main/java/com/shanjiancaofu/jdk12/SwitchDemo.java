package com.shanjiancaofu.jdk12;

public class SwitchDemo {
    public static void main(String[] args) {
        // switch 增强
        var str = "1";

        // 使用更加间接的switch
        // 使用： 没有自动穿透， 如果使用新的语法 -> 可以自动穿透
        switch (str) {
            case "1":
                System.out.println(str);
            case "2", "3": {
                System.out.println(str);
            }
        }
        switch (str) {
            case "1" -> {
                System.out.println(str);
            }
            case "2", "3" -> {
                System.out.println(str);
            }
        }
    }
}

