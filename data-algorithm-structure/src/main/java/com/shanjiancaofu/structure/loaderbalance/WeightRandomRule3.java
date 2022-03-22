package com.shanjiancaofu.structure.loaderbalance;

import java.util.HashMap;

/**
 * 权重随机算法3 (这个负载均衡目来自csdn https://blog.csdn.net/weixin_36586564/article/details/103919605)
 */
public class WeightRandomRule3 {
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
		java.util.Random random = new java.util.Random();
		int randomPos = -1;
		try {
			randomPos =random.nextInt(totalWeight);
		} catch (Exception e) {
			System.out.println(e);
		}

		if (!sameWeight) {
			for (String ip : ServerIps.WEIGHT_LIST.keySet()) {
				Integer value = ServerIps.WEIGHT_LIST.get(ip);
				if (randomPos < value) {
					return ip;
				}
				randomPos = randomPos - value;
			}
		}
		return (String) ServerIps.WEIGHT_LIST.keySet().toArray()[new
			java.util.Random().nextInt(ServerIps.WEIGHT_LIST.size())];
	}

	public static void main(String[] args) {


		HashMap<String, Integer> countMap = new HashMap<>();
		for (int i = 0; i < 100000; i++) {
			String server1 = getServer();
			countMap.merge(server1, 1, Integer::sum);
		}
		System.out.println(countMap);
	}
}

