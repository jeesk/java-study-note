package com.shanjiancaofu.structure.loaderbalance;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机算法
 */
public class RandomRule {
	public static String getIp(List<String> ips) {
		if (ips == null || ips.size() == 0) {
			throw new IllegalArgumentException("args ips is null");
		}
		int index = ThreadLocalRandom.current().nextInt(ips.size());
		return ips.get(index);
	}

	public static void main(String[] args) {
		List<String> ips = new ArrayList<>();
		{
			ips.add("192.168.0.1");
			ips.add("192.168.0.2");
			ips.add("192.168.0.3");
			ips.add("192.168.0.4");
			ips.add("192.168.0.5");
		}
		for (int i = 0; i < 20; i++) {
			System.out.println(getIp(ips));
		}
	}


}
