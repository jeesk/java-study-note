package com.shanjiancaofu.juc.thread.chapter08;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    static CyclicBarrier c = new CyclicBarrier(3);

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
		Set<Integer> set = new TreeSet<>();
		set.add(2);
		set.add(1);
		set.add(10);
		for (Integer integer : set) {
			System.out.println(integer);
		}

		LinkedHashSet<Integer> set2 = new LinkedHashSet<>();
		set2.add(2);
		set2.add(1);
		set2.add(10);
		set.add(2);
		for (Object o : set2) {
			System.out.println(o);
		}
		/**
		 * 1.按照插入顺序遍历 默认是插入顺序
		 *
		 * 2.按照访问顺序遍历
		 */
		LinkedHashMap<String,Integer> objectObjectLinkedHashMap = new LinkedHashMap<String,Integer>(10,0.75F,true);
		objectObjectLinkedHashMap.put("hello", 3);
		objectObjectLinkedHashMap.put("word", 2);
		objectObjectLinkedHashMap.put("nihao", 1);
		objectObjectLinkedHashMap.put("u", 4);
		objectObjectLinkedHashMap.get("hello");
		objectObjectLinkedHashMap.forEach((s, integer) -> System.out.println(s+":"+integer));

	}
}
