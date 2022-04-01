package com.shanjiancaofu.annotion;

import java.lang.annotation.*;

/**
 * @author jeesk
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TestDocumentedAnnotaion {
	/**
	 *
	 * @return return version
	 */
	String version() default "0.5";
}
