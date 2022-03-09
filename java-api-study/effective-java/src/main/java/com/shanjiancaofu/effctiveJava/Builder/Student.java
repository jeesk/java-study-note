package com.shanjiancaofu.effctiveJava.Builder;

import org.junit.Test;

public class Student {
    // Builder 模式

    private String name;
    private int age;
    private int height;


    public Student(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }


    public static StudentBuilder builder() {
        return new StudentBuilder();
    }


    static class StudentBuilder implements Builder<Student> {
        private String name;
        private int age;
        private int height;

        public StudentBuilder name(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder age(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder height(int height) {
            this.height = height;
            return this;
        }

        @Override
        public Student build() {
            return new Student(this);
        }

//        public Student build() {
//            return new Student(this.name, this.age, this.height);
//        }


    }

    public Student(StudentBuilder studentBuilder) {
        this.age = studentBuilder.age;
        this.height = studentBuilder.height;
        this.name = studentBuilder.name;
    }

}


interface Builder<T> {
    T build();
}

class BuilderPatter {
    @Test
    public void test() {

        Student.StudentBuilder age = Student.builder().age(1);
        Student build = age.build();
    }
}
