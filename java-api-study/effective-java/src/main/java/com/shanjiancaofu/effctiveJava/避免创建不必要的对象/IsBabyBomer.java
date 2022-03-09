package com.shanjiancaofu.effctiveJava.避免创建不必要的对象;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class IsBabyBomer {

    private final Date birthDate = null;

    public boolean isBaby() {
        Calendar calendat = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendat.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        Date startTime = calendat.getTime();
        calendat.set(1947, Calendar.JANUARY, 1, 0, 0, 0);
        Date endTime = calendat.getTime();

        return birthDate.compareTo(endTime) > 0 && birthDate.compareTo(startTime) < 0;

        // 每次在调用isBaby方法的是时候，都会创建一个calendate， startTime , endTime
        // 如果可以打上面的变成申明成静态的成员变量，  并且   在static 代码块中， 初始化即可。
        // 这样的效率更高一点

    }

    @Test
    public void mapTest() {

        long time = System.currentTimeMillis();
       long a = 0L;
       for (long i=0;i<Integer.MAX_VALUE;i++){

           a += i;
       }

        System.out.println(System.currentTimeMillis()-time);

    }
}
