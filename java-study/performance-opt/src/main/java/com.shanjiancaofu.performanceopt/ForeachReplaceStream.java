package com.shanjiancaofu.performanceopt;


import java.util.ArrayList;
import java.util.List;

public class ForeachReplaceStream {
	public static void main(String[] args) {
		long count = 10000000;
		List<Object> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			list.add(i);
		}
		long start = System.currentTimeMillis();
		for (long i = 0; i < count; i++) {
			for (Object o : list) {
				o.toString();
			}
		}
		System.out.println("foreach costs time " + (System.currentTimeMillis() - start) + "ms");
		start = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			list.stream().forEach(obj -> {
				obj.toString();
			});
		}
		System.out.println("stream costs time " + (System.currentTimeMillis() - start) + "ms");
	}
}
