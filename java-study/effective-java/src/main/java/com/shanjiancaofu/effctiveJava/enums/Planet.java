package com.shanjiancaofu.effctiveJava.enums;

public enum Planet {

    ONE,TWO;

}

class Plane {
    public static void main(String[] args) {
        Planet[] values = Planet.values();
        for (Planet value : values) {
            System.out.println(value.ordinal());
            System.out.println(value.toString());

        }
        System.out.println(values);
        Planet one = Planet.valueOf("ONE");
        System.out.println(one.ordinal());

    }
}
