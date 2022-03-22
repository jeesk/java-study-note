package com.shanjiancaofu.structure.loaderbalance;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 权重随机算法1
 */
public class WeightRandomRule1 {
	public static void main(String[] args) {
		List<Server> servers = new ArrayList<>();
		{
			servers.add(new Server("192.168.17.1", 1));
			servers.add(new Server("192.168.17.2", 2));
			servers.add(new Server("192.168.17.3", 3));
			servers.add(new Server("192.168.17.4", 4));
			servers.add(new Server("192.168.17.5", 4));
		}
		List<Server> weightServers = new ArrayList<>();
		servers.forEach(obj -> {
			for (int i = 0; i < obj.weight; i++) {
				weightServers.add(new Server(obj.ip, obj.weight));
			}
		});


		HashMap<String, Integer> countMap = new HashMap<>();
		for (int i = 0; i < 100000; i++) {
			Server server = getServer(weightServers);
			System.out.println(server);
			countMap.merge(server.ip, 1, Integer::sum);
		}
		System.out.println(countMap);

	}

	public static Server getServer(List<Server> servers) {
		if (servers == null || servers.size() == 0) {
			throw new IllegalArgumentException("args ips is null");
		}
		int index = ThreadLocalRandom.current().nextInt(servers.size());
		return servers.get(index);
	}

	@AllArgsConstructor
	@NoArgsConstructor
	@ToString
	public static class Server {
		private String ip;
		private int weight;
	}
}
