package com.shanjiancaofu.annotion.repeatble;

import java.lang.annotation.*;

public class RepeatbleAnnoTest {
	public static void main(String[] args) {
		Student1 student = new Student1();
		for (Annotation annotation : student.getClass().getAnnotations()) {
			System.out.println(annotation);
		}
		System.out.println("----------");
		Student2 student2 = new Student2();
		for (Annotation annotation : student2.getClass().getAnnotations()) {
			System.out.println(annotation);
		}

	}
}



@Roles(value = {
	@Role(role =  "group leader"),
	@Role(role =  "math leader"),
})
class Student1{

}


@Role(role =  "group leader")
@Role(role =  "math leader")
class Student2{

}

@Repeatable(Roles.class)
@interface Role {
	String role() default "";
}


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
   @interface Roles {
	Role[] value();
}


