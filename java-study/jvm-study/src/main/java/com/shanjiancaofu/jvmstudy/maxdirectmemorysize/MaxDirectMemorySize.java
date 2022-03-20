package com.shanjiancaofu.jvmstudy.maxdirectmemorysize;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class MaxDirectMemorySize {
	public static void main(String[] args) throws IllegalAccessException {
		Field declaredField = Unsafe.class.getDeclaredFields()[0];
		declaredField.setAccessible(true);
		Unsafe o = ((Unsafe) declaredField.get(null));
		o.allocateMemory(1024 * 1024);
	}
}
