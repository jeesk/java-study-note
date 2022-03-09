
package com.shanjiancaofu.juc.thread.datesafe;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @Description
 * @Author 宋奇福 <meetsong@foxmail.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2018/9/16 22:25
 */
public class ThreadDateDemo {
    // 一般情况下面建议是用ThreadExcutorPool
    // 如果是使用Excutor来执行   FixedThreadPool 和SinggleThreacPool执行的话可能会造成大量的的线程请求的堆积
    // 如果是CacheThredpool,或者是ScheduleThreadPool的话可能会造成创建大量的线程造成内存溢出


    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };


}
