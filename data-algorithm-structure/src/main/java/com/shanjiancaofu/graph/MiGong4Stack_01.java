package com.shanjiancaofu.graph;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Stack;

/**
 * 使用栈走出迷宫， 不一定是最优的解。 深度优先遍历
 */
public class MiGong4Stack_01 {

	public static void main(String[] args) {
		int[][] map = {
			{0, 1, 0, 0, 0, 1},
			{0, 0, 0, 1, 0, 1},
			{0, 0, 0, 1, 0, 1},
			{0, 1, 0, 1, 0, 1},
			{0, 0, 0, 0, 0, 0},
			{0, 1, 1, 1, 1, 0}
		};
		findWay(map, new Node(0, 0), new Node(5, 5));
	}


	public static void findWay(int[][] arr, Node sourceNode, Node targetNode) {
		Stack<Node> statck = new Stack<>();
		statck.push(sourceNode);
		int[][] visited = new int[6][6];
		// 定义方向如何走， 目前定义了右和下走，也可以把上下左右都定义了
		int[][] direction = {
			{0, 1},
			{1, 0}
		};
		while (!statck.isEmpty()) {
			Node pop = statck.peek();
			boolean isWay = false;
			if (pop.x == targetNode.x && pop.y == targetNode.y) {
				break;
			} else {
				for (int[] ints : direction) {
					Node node = new Node(ints[0] + pop.getX(), ints[1] + pop.y);
					boolean boundary = node.getX() >= 0 && node.getY() >= 0 && node.getX() <= 5 && node.getY() <= 5;
					if (boundary && arr[node.getX()][node.getY()] != 1 && visited[node.getX()][node.getY()] == 0) {
						statck.push(node);
						visited[node.getX()][node.getY()] = 1;
						isWay = true;
						break;
					}
				}
				if (isWay) {
					continue;
				}
				// 后退一步
				statck.pop();
			}
		}
		Stack<Node> findWays = new Stack<>();
		while (!statck.isEmpty()) {
			findWays.push(statck.pop());
		}
		while (!findWays.isEmpty()) {
			Node pop = findWays.pop();
			System.out.println(String.format("(%s,%s)", pop.getX(), pop.getY()));
		}
	}

	@Setter
	@Getter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Node {
		private int x;
		private int y;
	}


}
