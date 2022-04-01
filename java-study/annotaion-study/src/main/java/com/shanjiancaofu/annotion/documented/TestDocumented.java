package com.shanjiancaofu.annotion.documented;

import java.lang.annotation.*;
@VersionDocumented(version = "0.1",author = "jeesk")
public class TestDocumented {
	public static void main(String[] args) {

	}
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@interface VersionDocumented {
	String version() ;
	String author();
}

