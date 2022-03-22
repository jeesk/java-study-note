package com.shanjiancaofu.structure.loaderbalance;

import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 轮询策略(暂时还没有想到怎么使用排序的方式去做权重轮询， 数学水平有限）
 */
public class RoundRobinRule {
	static AtomicInteger atomicInt = new AtomicInteger(0);

	public static void main(String[] args) {


		List<RoundRobinRule.Server> servers = new ArrayList<>();
		{
			servers.add(new RoundRobinRule.Server("192.168.17.1"));
			servers.add(new RoundRobinRule.Server("192.168.17.2"));
			servers.add(new RoundRobinRule.Server("192.168.17.3"));
			servers.add(new RoundRobinRule.Server("192.168.17.4"));

		}


		HashMap<String, Integer> countMap = new HashMap<>();
		for (int i = 0; i < 100000; i++) {
			RoundRobinRule.Server server = getServer(servers);
			System.out.println(server);
			countMap.merge(server.ip, 1, Integer::sum);
		}
		System.out.println(countMap);
	}

	static Integer pos = 0;

	public static RoundRobinRule.Server getServer(List<RoundRobinRule.Server> servers) {
		if (servers == null || servers.size() == 0) {
			throw new IllegalArgumentException("args ips is null");
		}
		// 这里取模是让 atomicInt 在 0 ~ server.size-1 这个范围滚动
		int andUpdate = atomicInt.getAndAdd(1);
		andUpdate = (andUpdate) % servers.size();

		// 或者使用synchronized, 这里推荐使用atomicInt 的方式
		/*		synchronized (pos) {
			if (pos >= servers.size()) {
				pos = 0;
			}
			pos++;
		}*/

		return servers.get(andUpdate);
	}


	@AllArgsConstructor
	@NoArgsConstructor
	@ToString
	@Setter
	@Getter
	public static class Server {
		private String ip;
		private int weight;

		public Server(String ip) {
			this.ip = ip;
		}
	}
}
