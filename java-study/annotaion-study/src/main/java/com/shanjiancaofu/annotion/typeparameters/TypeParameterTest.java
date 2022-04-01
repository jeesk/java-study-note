package com.shanjiancaofu.annotion.typeparameters;

import java.lang.reflect.TypeVariable;

public class TypeParameterTest {
	public static void main(String[] args) {
		Demo2<String, Integer, String> demo2 = new Demo2<>();
		TypeVariable<? extends Class<? extends Demo2>>[] typeParameters = demo2.getClass().getTypeParameters();
		for (TypeVariable<? extends Class<? extends Demo2>> typeParameter : typeParameters) {
			System.out.println("name:" + typeParameter.getName() +", index = " + typeParameter.getBounds());
		}
	}
}
class Demo2<T,B,A>{ }
