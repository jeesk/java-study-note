package com.shanjiancaofu.annotion.rentaion;

import java.lang.annotation.Annotation;


public class TestAnnotaion {

	private void privateMethod(){

	}

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		printAnnotaion(Test4Source.class);
		System.out.println("----------------");
		printAnnotaion(Test4Class.class);
		System.out.println("----------------");
		printAnnotaion(Test4Runtime.class);

		Class<?> testAnnotaion = Class.forName("com.shanjiancaofu.annotion.rentaion.TestAnnotaion");
		System.out.println(Float.TYPE.isPrimitive());

	}
	public static void printAnnotaion(Class clazz) throws InstantiationException, IllegalAccessException {
		Object o = clazz.newInstance();
		Annotation[] declaredAnnotations = o.getClass().getDeclaredAnnotations();
		for (Annotation declaredAnnotation : declaredAnnotations) {
			System.out.println("注解名字: "+declaredAnnotation.toString());
		}
	}
}


@SourceAnnotaion
class Test4Source{

}

@ClassAnnotation
class Test4Class{


}
@RuntimeAnnotaion
class Test4Runtime{

}

