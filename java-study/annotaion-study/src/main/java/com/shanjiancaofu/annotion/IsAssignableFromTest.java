package com.shanjiancaofu.annotion;

public class IsAssignableFromTest {
	public static void main(String[] args) {
		System.out.println("Object 是否是Student的父类：" + Object.class.isAssignableFrom(Student.class));
		System.out.println("Person 是否是Student的超父类：" + Person.class.isAssignableFrom(Student.class));
		System.out.println("WalkAble 是否是Student的父接口：" + WalkAble.class.isAssignableFrom(Student.class));
	}
}

class Person{ }

class Student extends Person implements WalkAble { }

interface WalkAble{ }
