package com.shanjiancaofu.performanceopt;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class ConcurrentHashMapTest {
	static final int MAP_SIZE = 20;
	static final int THREADS = 20;
	static final ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();

	static {
		for (int i = 0; i < MAP_SIZE; i++) map.put(i, i);
	}

	static class TestThread extends Thread {
		public void run() {
			int i = 0;
			int result = 0;
			while (result < Integer.MAX_VALUE) {
				i = (i + 1) % MAP_SIZE;
				result += map.computeIfAbsent(i, (key) -> key + key);
			}
		}
	}

	public static void main(String[] v) throws InterruptedException {
		ArrayList<Thread> threads = new ArrayList<>();
		for (int i = 0; i < THREADS; i++) {
			TestThread t = new TestThread();
			threads.add(t);
			t.start();
		}
		threads.get(0).join();
	}

	// 代替默认的 computeIfAbsent ， 这个问题在Jkd 1.9 中已经修复了
	public static <K, V> V computeIfAbsent(Map<K, V> concurrentHashMap, K key, Function<? super K, ? extends V> mappingFunction) {
		V v = concurrentHashMap.get(key);
		if (v != null) {
			return v;
		}
		return concurrentHashMap.computeIfAbsent(key, mappingFunction);
	}
}
