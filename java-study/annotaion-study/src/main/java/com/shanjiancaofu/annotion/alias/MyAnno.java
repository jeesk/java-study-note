package com.shanjiancaofu.annotion.alias;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
	String value() default "";

}

@MyAnno("default value")
class Demo{
	public static void main(String[] args) {
		Demo demo = new Demo();
		MyAnno declaredAnnotation = demo.getClass().getDeclaredAnnotation(MyAnno.class);
		System.out.println("value: "+declaredAnnotation.value());

	}
}
