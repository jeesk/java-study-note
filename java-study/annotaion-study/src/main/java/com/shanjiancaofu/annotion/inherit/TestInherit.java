package com.shanjiancaofu.annotion.inherit;

import java.lang.annotation.*;

public class TestInherit {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		printAnnotaion(Son.class);
		System.out.println("-------------------------");
		printAnnotaion(Tiger.class);
		System.out.println("-------------------------");
		printAnnotaion(Doll.class);
	}
	public static void printAnnotaion(Class clazz) throws InstantiationException, IllegalAccessException {
		Object o = clazz.newInstance();
		// 获取注解(包括继承的）
		Annotation[] declaredAnnotations = o.getClass().getAnnotations();
		if(declaredAnnotations.length == 0){
			System.out.println("找不到注解");
		}else{
			for (Annotation declaredAnnotation : declaredAnnotations) {
				System.out.println("注解名字: "+declaredAnnotation.toString());
			}
		}
	}
}


@Target(ElementType.TYPE_USE)
@Retention(RetentionPolicy.RUNTIME)
 @interface NameAnno {
	String name();
}

@NameAnno(name = "animal")
class Animal {

}
@NameAnno(name = "father")
class Father{

}
@NameAnno(name = "son")
class Son extends Father{

}

class Tiger extends Animal {

}

@NameAnno(name = "person")
interface Person{

}


class Doll implements Person{

}
