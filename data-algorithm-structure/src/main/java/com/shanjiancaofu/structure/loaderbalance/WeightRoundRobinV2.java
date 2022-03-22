package com.shanjiancaofu.structure.loaderbalance;

import java.util.HashMap;

/**
 * 权重平滑加轮询算法
 */
public class WeightRoundRobinV2 {
	private static HashMap<String, Weight> weightMap = new HashMap();

	public static String getServer() {
		// java8
		int totalWeight = ServerIps.WEIGHT_LIST.values().stream().reduce(0, Integer::sum);

		// 初始化weightMap，初始值currentWeight复制为weight
		if (weightMap.isEmpty()) {
			ServerIps.WEIGHT_LIST.forEach((key, value) -> {
				weightMap.put(key, new Weight(key, value, value));
			});
		}
		// 找出currentWeight最大值
		Weight maxCurrentWeight = null;
		for (Weight weight : weightMap.values()) {
			if (maxCurrentWeight == null || weight.getCurrentWeight() >
				maxCurrentWeight.getCurrentWeight()) {
				maxCurrentWeight = weight;
			}
		}
		// 将maxCurrentWeight减去总权重和
		maxCurrentWeight.setCurrentWeight(maxCurrentWeight.getCurrentWeight() -
			totalWeight);
		// 所有的ip的currentWeight统一加上权重
		for (Weight weight : weightMap.values()) {
			weight.setCurrentWeight(weight.getCurrentWeight() + weight.getWeight());
		}
		// 返回maxCurrentWeight所对应的ip
		return maxCurrentWeight.getIp();
	}

	public static void main(String[] args) {
		//连续调用10次
		for (int i = 0; i < 10; i++) {
			System.out.println(getServer());
		}
	}
}

