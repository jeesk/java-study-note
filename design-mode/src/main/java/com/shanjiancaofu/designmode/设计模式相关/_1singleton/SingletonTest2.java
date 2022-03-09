package com.shanjiancaofu.designmode.设计模式相关._1singleton;


import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 通过反射是否可以破坏单单例模式
 */
public class SingletonTest2 {


    @Test
    public void testSingleton1() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<HungryManMode> aClass = (Class<HungryManMode>) Class.forName("com.shanjiancaofu.designmode.设计模式相关._1singleton.Singleton1");
        Constructor<HungryManMode> constructor = aClass.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        HungryManMode singleton1 = constructor.newInstance();
        HungryManMode singleton2 = constructor.newInstance();

        Assert.assertNotSame("单例模式被破坏", singleton1, singleton2);  // 单例模式被破坏
    }


    @Test
    public void testSingleton2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // Singleton2 instance = Singleton2.getInstance();

        // 通过构造器抛出异常, 防止调用梏器
        HungryManMode instance2 = HungryManMode.getInstance(); //
        Class<Slacker> aClass = (Class<Slacker>) Class.forName("com.shanjiancaofu.designmode.设计模式相关._1singleton.Singleton2");
        Constructor<Slacker> constructor = aClass.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        Slacker singleton1 = constructor.newInstance();
        Slacker singleton2 = constructor.newInstance();
        // Assert.assertNotEquals("单例模式被破坏", singleton1, singleton2);  // 单例模式被破坏

    }


    @Test
    public void testSingleton3() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException {
        // Singleton2 instance = Singleton2.getInstance();

        HungryManMode instance = HungryManMode.getInstance();
        System.out.println(instance);

        FileOutputStream fileOutputStream = new FileOutputStream("/home/jeesk/MyProject/degisnPaternFor24/src/main/java/resources/123.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(instance);
        fileOutputStream.close();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("/home/jeesk/MyProject/degisnPaternFor24/src/main/java/resources/123.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        HungryManMode o = (HungryManMode) objectInputStream.readObject();
        System.out.println(0);
        fileInputStream.close();
        objectInputStream.close();

        Assert.assertEquals(instance, o);
        // 重写readResolvew, 保证在序列化的时候也是 同一个对象这


    }

}
