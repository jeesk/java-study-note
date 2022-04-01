package com.shanjiancaofu.annotion.superclass;

public class SuperClassTest {
	public static void main(String[] args) {
		System.out.println(Person.class.getSuperclass().getName());
		System.out.println();
		Person.class.getName();
		Person.class.getTypeName();
		Person.class.getSimpleName();
		Person.class.getCanonicalName();
	}
}




class Person{

}

class Stu extends   Person{

}
