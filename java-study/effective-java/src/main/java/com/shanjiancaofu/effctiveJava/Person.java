package com.shanjiancaofu.effctiveJava;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Person {
    private String name;
    private int age;
    private float age1;
    private double age2;
    private boolean isSelf;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Float.compare(person.age1, age1) == 0 &&
                Double.compare(person.age2, age2) == 0 &&
                isSelf == person.isSelf &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {

        AtomicInteger int1 = new AtomicInteger();


        return Objects.hash(name, age, age1, age2, isSelf);
    }
}
