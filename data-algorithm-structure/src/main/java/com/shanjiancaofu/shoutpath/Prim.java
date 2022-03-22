package com.shanjiancaofu.shoutpath;

import java.util.Arrays;

/**
 * 普得姆算法(最小路径算法） ， 通过一个顶点设置为已经访问过， 然后通过这一个路径去找一个最短路径，然后记录下来， 再进行找下一次
 */
public class Prim {
	public static void main(String[] args) {
		// 给一个顶点， 然后通过这个顶点每次去找最短路径， 直到图里的所有的顶点都找到就结束了
		MinTree minTree = new MinTree();
		char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
		int verxs = data.length;
		// 10000 表示不连同
		int[][] weight = new int[][]{
			{10000, 5, 7, 10000, 10000, 10000, 2},
			{5, 10000, 10000, 9, 10000, 10000, 3},
			{7, 10000, 10000, 10000, 8, 10000, 10000},
			{10000, 9, 10000, 10000, 10000, 4, 10000},
			{10000, 10000, 8, 10000, 10000, 5, 4},
			{10000, 10000, 10000, 4, 5, 10000, 6},
			{2, 3, 10000, 10000, 4, 6, 10000},};
		MGraph graph = minTree.createGraph(verxs, data, weight);
		minTree.prim(graph, 1);
		// 这里的index 不同， 但是最后的权重都是一样的
		//minTree.prim(graph, 3);


	}


	public static class MinTree {
		public MGraph createGraph(int verxs, char[] data, int[][] metexts) {
			MGraph mGraph = new MGraph(verxs);
			mGraph.data = data;
			mGraph.metexts = metexts;
			return mGraph;
		}

		public void showGraph(MGraph mGraph) {
			for (int[] metext : mGraph.metexts) {
				System.out.println(Arrays.toString(metext));
			}
		}

		public void prim(MGraph mGraph, int index) {
			// 给定一个最小的顶点
			// 通过这个顶点每次获取最小权重的边， 然后记录下来这个顶点

			int[] visited = new int[mGraph.verxs];
			visited[index] = 1;
			// //因为有 graph.verxs顶点，普利姆算法结束后，有 graph.verxs-1边
			int lenth = mGraph.verxs - 1;
			while (lenth-- > 0) {
				int minWeight = 10000;
				// 记录两个顶点的下标
				int h1 = -1;
				int h2 = -2;
				//这个是确定每一次生成的子图 ，和哪个结点的距离最近
				for (int j = 0; j < mGraph.verxs; j++) { // j结点表示被访问过的结点
					for (int k = 0; k < mGraph.verxs; k++) { // k结点表示还没有访问过的结点
						if (visited[j] == 1 && visited[k] == 0 && minWeight > mGraph.metexts[j][k]) {
							//替换minWeight(寻找已经访问过的结点和未访问过的结点间的权值最小的边)
							minWeight = mGraph.metexts[j][k];
							h1 = j;
							h2 = k;
						}
					}
				}
				// 记录j2已经被使用过了
				visited[h2] = 1;
				System.out.println("边:" + mGraph.data[h1] + "," + mGraph.data[h2] + ", 权值：" + mGraph.metexts[h1][h2]);
			}

			System.out.println();
		}

	}


	public static class MGraph {
		private int verxs; // 顶点个数
		private char[] data;// 顶点数据
		private int[][] metexts; // 边

		public MGraph(int verxs) {
			this.verxs = verxs;
			data = new char[verxs];
			metexts = new int[verxs][verxs];
		}
	}

}
