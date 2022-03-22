package com.shanjiancaofu.structure.loaderbalance;

import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 权重随机算法2(权重算法3是权重算法的另一种写法）
 */
public class WeightRandomRule2 {
	public static void main(String[] args) {
		List<WeightRandomRule2.Server> servers = new ArrayList<>();
		{
			servers.add(new WeightRandomRule2.Server("192.168.17.1", 1));
			servers.add(new WeightRandomRule2.Server("192.168.17.2", 2));
			servers.add(new WeightRandomRule2.Server("192.168.17.3", 3));
			servers.add(new WeightRandomRule2.Server("192.168.17.4", 4));
			servers.add(new WeightRandomRule2.Server("192.168.17.5", 4));
		}


		HashMap<String, Integer> countMap = new HashMap<>();
		for (int i = 0; i < 100000; i++) {
			WeightRandomRule2.Server server = getServer(servers);
			System.out.println(server);
			countMap.merge(server.ip, 1, Integer::sum);
		}
		System.out.println(countMap);
	}

	public static WeightRandomRule2.Server getServer(List<WeightRandomRule2.Server> servers) {
		if (servers == null || servers.size() == 0) {
			throw new IllegalArgumentException("args ips is null");
		}

		int totalWeight = servers.stream().map(Server::getWeight).reduce(Integer::sum).get();
		List<Double> weights = new ArrayList<>(servers.size() + 1);
		double tempWeight = 0;
		for (Server server : servers) {
			tempWeight += server.weight;
			weights.add(tempWeight / totalWeight);
		}
		double randomValue = ThreadLocalRandom.current().nextDouble(1);

		weights.add(randomValue);
		Collections.sort(weights);

		int index = -1;
		for (int i = 0; i < weights.size(); i++) {
			if (weights.get(i) == randomValue) {
				index = i;
				break;
			}
		}
		return servers.get(index);
	}

	@AllArgsConstructor
	@NoArgsConstructor
	@ToString
	@Setter
	@Getter
	public static class Server {
		private String ip;
		private int weight;
	}
}
