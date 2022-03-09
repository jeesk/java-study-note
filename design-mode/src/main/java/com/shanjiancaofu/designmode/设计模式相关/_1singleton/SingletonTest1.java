package com.shanjiancaofu.designmode.设计模式相关._1singleton;


import org.junit.Assert;
import org.junit.Test;

/**
 * 比较 对象是否是单例子
 *
 */
public class SingletonTest1 {

    @Test
    public void testSingleton1() {
        HungryManMode singleton1 = HungryManMode.getInstance();
        HungryManMode singleton11 = HungryManMode.getInstance();
        Assert.assertEquals(singleton1, singleton11);
    }

    @Test
    public void testSingleton2() {
        Slacker singleton1 = Slacker.getInstance();
        Slacker singleton11 = Slacker.getInstance();
        Assert.assertEquals(singleton1, singleton11);
    }

    @Test
    public void testSingleton3() {
        HungryManStaticBlockCodeMode singleton1 = HungryManStaticBlockCodeMode.getInstance();
        HungryManStaticBlockCodeMode singleton11 = HungryManStaticBlockCodeMode.getInstance();
        Assert.assertEquals(singleton1, singleton11);
    }

    @Test
    public void testSingleton4() {
        SlackerStaticClassMode singleton1 = SlackerStaticClassMode.getInstance();
        SlackerStaticClassMode singleton11 = SlackerStaticClassMode.getInstance();
        Assert.assertEquals(singleton1, singleton11);
    }

    @Test
    public void testSingleton5() {
        SlackerDoubleCheckMode singleton1 = SlackerDoubleCheckMode.getInstance();
        SlackerDoubleCheckMode singleton11 = SlackerDoubleCheckMode.getInstance();
        Assert.assertEquals(singleton1, singleton11);
    }

    @Test
    public void testSingleton6() {
        HungryManEnumMode singleton1 = HungryManEnumMode.INSTANCE;
        HungryManEnumMode singleton11 = HungryManEnumMode.INSTANCE;
        Assert.assertEquals(singleton1, singleton11);
    }


}
