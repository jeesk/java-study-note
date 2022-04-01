package com.shanjiancaofu.annotion.field;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface VersionAnnotaion {
	String version() default "0.5";
	String[] compatibleVersion();
}
