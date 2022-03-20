package com.shanjiancaofu.effctiveJava.重试机制.切面方式;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RetryDot {
    /**
     * 重试次数
     *
     * @return
     */
    int count() default 0;


    /**
     * 重试的间隔时间
     *
     * @return
     */
    int sleep() default 0;


    /**
     * 是否支持异步重试方式
     *
     * @return
     */
    boolean asyn() default false;
}
