package com.shanjiancaofu.effctiveJava.用私有构造器或者是枚举强化Sington发展;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Evlis {

    private static int b = 0;

    private static final Evlis instance = new Evlis();

    private Evlis() {
        b++;
        if (b == 2) {
            throw new RuntimeException("不允许私自调用构造器");
        }
    }

    public static Evlis getInstance() {
        return instance;
    }

    int a = 2;
}

class Demo {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException {
        Constructor<Evlis> declaredConstructor = Evlis.class.getDeclaredConstructor(null);
        // 通过设置 Accessiablet和, 可以访问私有的构造器
        declaredConstructor.setAccessible(true);
        Evlis evlis = (Evlis) declaredConstructor.newInstance();
        System.out.println(evlis.a);
       // System.out.println(Evlis.getInstance().a);

    }

    @Test
    public void testConstrutor() {
        System.out.println(Evlis.getInstance().a);
    }

}
