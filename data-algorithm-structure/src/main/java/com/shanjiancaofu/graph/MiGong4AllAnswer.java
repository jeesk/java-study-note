package com.shanjiancaofu.graph;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wolf on 2016/3/21.
 */
public class MiGong4AllAnswer {
	/**
	 * 定义迷宫数组
	 */
	private int maxLine = 8;
	private int maxRow = 9;
	private int[][] array = {
		{0, 0, 1, 0, 0, 0, 1, 0},
		{0, 0, 1, 0, 0, 0, 1, 0},
		{0, 0, 1, 0, 1, 1, 0, 1},
		{0, 1, 1, 1, 0, 0, 1, 0},
		{0, 0, 0, 1, 0, 0, 0, 0},
		{0, 1, 0, 0, 0, 1, 0, 1},
		{0, 1, 1, 1, 1, 0, 0, 1},
		{1, 1, 0, 0, 0, 1, 0, 1},
		{1, 1, 0, 0, 0, 0, 0, 0}
	};


	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		new MiGong4AllAnswer().check(0, 0, new LinkedList<>());
		System.out.println(System.currentTimeMillis());
	}

	private void check(int i, int j, LinkedList<Node> nodes) {
		//如果到达右下角出口
		if (i == maxRow - 1 && j == maxLine - 1) {
			print(nodes);
			return;
		}
		//向右走
		if (canMove(i, j, i, j + 1)) {
			array[i][j] = 5;
			nodes.addLast(new Node(i, j));
			check(i, j + 1, nodes);
			array[i][j] = 0;
			nodes.removeLast();
		}
		//向左走
		if (canMove(i, j, i, j - 1)) {
			array[i][j] = 5;
			nodes.addLast(new Node(i, j));
			check(i, j - 1, nodes);
			array[i][j] = 0;
			nodes.removeLast();
		}
		//向下走
		if (canMove(i, j, i + 1, j)) {
			array[i][j] = 5;
			nodes.addLast(new Node(i, j));
			check(i + 1, j, nodes);
			array[i][j] = 0;
			nodes.removeLast();
		}
		//向上走
		if (canMove(i, j, i - 1, j)) {
			array[i][j] = 5;
			nodes.addLast(new Node(i, j));
			check(i - 1, j, nodes);
			array[i][j] = 0;
			nodes.removeLast();
		}
	}

	private boolean canMove(int i, int j, int targetI, int targetJ) {
//        System.out.println("从第" + (i + 1) + "行第" + (j + 1) + "列，走到第" + (targetI + 1) + "行第" + (targetJ + 1) + "列");
		if (targetI < 0 || targetJ < 0 || targetI >= maxRow || targetJ >= maxLine) {
//            System.out.println("到达最左边或最右边，失败了");
			return false;
		}
		if (array[targetI][targetJ] == 1) {
//            System.out.println("目标是墙，失败了");
			return false;
		}
		//避免在两个空格间来回走
		if (array[targetI][targetJ] == 5) {

			return false;
		}
		return true;
	}

	private void print(LinkedList<Node> nodes) {
		System.out.println("得到一个解：");
		for (int i = 0; i < maxRow; i++) {
			for (int j = 0; j < maxLine; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("坐标");
		System.out.println(Arrays.toString(nodes.toArray()));
		System.out.println();
	}

	@Setter
	@Getter
	@AllArgsConstructor
	public static class Node {
		private int x;
		private int y;

		@Override
		public String toString() {
			return String.format("(%s,%s)", x, y);
		}
	}
}
