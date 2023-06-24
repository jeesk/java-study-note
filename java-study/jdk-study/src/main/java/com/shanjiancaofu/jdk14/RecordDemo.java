package com.shanjiancaofu.jdk14;


// kotlin 里面的data class ,java 里面的record
public class RecordDemo {
    public record Stu(
            String name, int age
    ) {

    }

    public static void main(String[] args) {
        var stu = new Stu("hello", 12);
        System.out.println(stu.name);

    }
}
