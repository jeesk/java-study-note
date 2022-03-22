package com.shanjiancaofu.structure.loaderbalance;

import java.util.HashMap;

/**
 * 权重加轮询算法
 */
public class WeightRoundRobin {
	public static Integer num = 0;

	public static String getServer() {
		int totalWeight = 0;
		boolean sameWeight = true; // 如果所以权重都相等，那么随机一个ip就好了
		Object[] weights = ServerIps.WEIGHT_LIST.values().toArray();
		for (int i = 0; i < weights.length; i++) {
			Integer weight = (Integer) weights[i];
			totalWeight += weight;
			if (sameWeight && i > 0 && !weight.equals(weights[i - 1])) {
				sameWeight = false;
			}
		}
		Integer sequenceNum = getAndIncrement();
		Integer offset = (sequenceNum) % totalWeight;
		if (offset == totalWeight) {
			// 这里的offset 永远小于totalWeight
			System.out.println("offset == totalWeight");
		}
		// 这里的offset 加一也行 offset +1
		//offset = offset == 0 ? totalWeight : offset;

		offset += 1;

		if (!sameWeight) {
			for (String ip : ServerIps.WEIGHT_LIST.keySet()) {
				Integer weight = ServerIps.WEIGHT_LIST.get(ip);
				if (offset <= weight) {
					return ip;
				}
				offset = offset - weight;
			}
		}
		return null;
	}

	public static Integer getAndIncrement() {
		return ++num;
	}

	public static void main(String[] args) {

		HashMap<String, Integer> countMap = new HashMap<>();
		for (int i = 0; i < 1000000; i++) {
			String server1 = getServer();
			countMap.merge(server1, 1, Integer::sum);
		}
		System.out.println(countMap);
	}
}

