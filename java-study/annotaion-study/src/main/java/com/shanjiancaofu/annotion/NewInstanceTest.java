package com.shanjiancaofu.annotion;

public class NewInstanceTest {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		NewInstance ni = NewInstance.class.newInstance();
		System.out.println("是否是一个实例对象：" + NewInstance.class.isInstance(ni));
		System.out.println("是否是一个实例对象：" + (ni instanceof NewInstance));
	}
}
class NewInstance{
	String name;
}
