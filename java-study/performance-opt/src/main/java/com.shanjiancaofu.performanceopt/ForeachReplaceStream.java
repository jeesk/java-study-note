package com.shanjiancaofu.performanceopt;



import java.util.ArrayList;
import java.util.List;

public class ForeachReplaceStream {
	public static void main(String[] args) {
		long count = 100000;
		List<Object> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			list.add(i);
		}
		long count1 =0;
		long start = System.currentTimeMillis();
		for (long i = 0; i < count; i++) {
			for (Object o : list) {
				o.toString();
				count1++;
			}
		}
		System.out.println("foreach costs time "+ (System.currentTimeMillis()-start) +"ms");
		for (int i = 0; i < count; i++) {
			list.stream().forEach(obj -> {
				obj.toString();
				count1++;
			});
		}
		start = System.currentTimeMillis();
		System.out.println("stream costs time "+ (System.currentTimeMillis()-start) +"ms");
	}
}
