package com.shanjiancaofu.designmode.设计模式相关._1singleton;


import java.io.ObjectStreamException;
import java.io.Serializable;

// 第一种：饿汉式. 线程安全， 速度快， 但是没有延迟加载
public class HungryManMode implements Serializable {

    private final static HungryManMode INSTANCE = new HungryManMode();
    private HungryManMode(){
        if(INSTANCE != null){
            throw new RuntimeException("不允许调用构造器");
        }
    }
    public static HungryManMode getInstance(){
        return INSTANCE;
    }

    //反序列化时，如果定义了readResolve()则直接返回此方法指定的对象。而不需要单独再创建新对象！
	private Object readResolve() throws ObjectStreamException {
		return INSTANCE;
	}
}



