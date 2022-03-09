package com.shanjiancaofu.effctiveJava.javaBeansmode;


import lombok.Builder;
import lombok.Getter;
import org.junit.Test;



@Builder(toBuilder = true)
@Getter
public class Person {
    private String name;
    private int age;
    private int height;
    private int width;
}

class Demo {
    @Test
    public void testDemo() {

        Person.PersonBuilder builder = Person.builder();
        Person age = Person.builder().age(1).build();
    }
}
