package com.shanjiancaofu.graph;

import java.util.*;

public class GraphDemo {
	public static void main(String[] args) throws InterruptedException {
		Graph graph = new Graph(8);
		// String[] arr = {"A", "B", "C", "D"};
		String Vertexs[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
		for (String s : Vertexs) {
			graph.addVertex(s);
		}

/*		graph.insertEdge(0, 1, 1);
		graph.insertEdge(0, 2, 1);
		graph.insertEdge(1, 2, 1);
		graph.insertEdge(1, 3, 1);*/


		graph.insertEdge(0, 1, 1);
		graph.insertEdge(0, 2, 1);
		graph.insertEdge(1, 3, 1);
		graph.insertEdge(1, 4, 1);
		graph.insertEdge(3, 7, 1);
		graph.insertEdge(4, 7, 1);
		graph.insertEdge(2, 5, 1);
		graph.insertEdge(2, 6, 1);
		graph.insertEdge(5, 6, 1);


		graph.showGrpah();
		System.out.println("深度遍历");
		//1->2->4->8->5->3->6->7->
		graph.dfs();
		// 1->2->3->4->5->6->7->8->
		System.out.println("广度遍历");
		graph.bfs();
		System.out.println("深度遍历");
		System.out.println();

	}


	public static class Graph {
		private List<String> vertexts;
		private int[][] edges;
		private int numberOfEdges;
		private boolean[] isVeisited;

		public Graph(int count) {
			vertexts = new ArrayList<>(count);
			edges = new int[count][count];
			isVeisited = new boolean[count];
		}

		/**
		 * 插入顶点的数据
		 * @param vertex
		 */
		public void addVertex(String vertex) {
			vertexts.add(vertex);
		}

		public String getVertext(int index) {
			return vertexts.get(index);
		}

		/**
		 *
		 * @param v1 第一个节点的索引
		 * @param v2 第干个节点的索引
		 * @param weight 权重（这里我们规定加入两个相交权重为1）
		 */
		public void insertEdge(int v1, int v2, int weight) {
			edges[v1][v2] = weight;
			edges[v2][v1] = weight;
			numberOfEdges++;
		}

		public void showGrpah() {
			for (int[] edge : edges) {
				System.out.println(Arrays.toString(edge));
			}
		}

		public String getValueByIndex(int index) {
			return vertexts.get(index);
		}

		/**
		 * 1. 访问初始节点v， 并标记节点v为已访问
		 * 2. 查找节点v的第一个邻节点w。
		 * 3. 若w存在， 那么继续执行4， 如果不存在，则回到第一步， 将从v的下一个节点继续
		 * 4. 如果w未被访问，则对w进行深度优先遍历（把w当做另外一个v， 进行步骤123）
		 * 5. 查找节点v的w邻节点的下一个邻节点，转到步骤3
		 *
		 * @param isVeisited
		 * @param index
		 */
		public void dfs(boolean[] isVeisited, int index) throws InterruptedException {
			String valueByIndex = getValueByIndex(index);
			System.out.print(valueByIndex + "->");
			isVeisited[index] = true;
			//
			int firstIndex = getFirtNeighbor(index);

			// 获取第一个领结节点，
			// 如果该节点存在那么获取下一个节点，
			while (firstIndex != -1) {
				if (!isVeisited[firstIndex]) {
					dfs(isVeisited, firstIndex);
				}
				// w如果被访问过了， 获取w的下一个节点
				firstIndex = getNextNeighbor(index, firstIndex);
			}

		}

		// 遍历所有的节点
		public void dfs() throws InterruptedException {

			isVeisited = new boolean[vertexts.size()];
			for (int i = 0; i < vertexts.size(); i++) {
				if (!isVeisited[i]) {
					dfs(isVeisited, i);
					System.out.println();
				}
			}
		}

		/**
		 * 根据前一个邻节点来获取下一个邻节点的坐标
		 * @param v1 第一个接点的索引
		 * @param v2 第一个接点的领节点索引
		 * @return
		 */
		public int getNextNeighbor(int v1, int v2) {
			for (int i = v2 + 1; i < vertexts.size(); i++) {
				if (edges[v1][i] > 0) {
					return i;
				}
			}
			return -1;
		}

		/**
		 * 得到该索引的第一个节点
		 *
		 * @param index
		 * @return
		 */
		public int getFirtNeighbor(int index) {
			for (int i = 0; i < vertexts.size(); i++) {
				if (edges[index][i] > 0) {
					return i;
				}
			}
			return -1;
		}


		/**
		 * 1. 访问初始节点v， 并标记 v为已经访问。
		 * 2. 节点v 入栈
		 * 3. 当队列为空的时候， 继续执行，否则算法失效
		 * 4. 出队列， 取出头节点u
		 * 5. 查找u的第一个领节点w
		 * 6. 当节点不存在的时候， 则转向步骤3，否则执行下面3个步骤
		 * 1. w节点没有被访问过，则标记w为已访问
		 * 2. 节点w入队列
		 * 3. 查询节点为u的继领结点后面的下一个邻节点w， 转到步骤6
		 *
		 * @param i
		 * @param isVeisited
		 */
		public void bfs(int i, boolean[] isVeisited) {
			int u; // 头节点下标
			int w;// 领节点下标
			LinkedList<Integer> queue = new LinkedList<>();
			System.out.print(getValueByIndex(i) + "->");
			isVeisited[i] = true;
			queue.addLast(i);
			while (!queue.isEmpty()) {
				// 获取第一个领节点下标
				u = queue.removeFirst();
				w = getFirtNeighbor(u);
				while (w != -1) {
					if (!isVeisited[w]) {
						isVeisited[w] = true;
						System.out.print(getValueByIndex(w) + "->");
						queue.addLast(w);
					}
					// 以u为前驱节点(不一定是是直接前驱)找w后面得下一个邻接点,  和u 相连， 限度为w， 后面可能没有了。 那么这一层查找完成
					w = getNextNeighbor(u, w);
				}
			}
		}


		public void bfs() {
			isVeisited = new boolean[vertexts.size()];
			for (int i = 0; i < vertexts.size(); i++) {
				if (!isVeisited[i]) {
					bfs(i, isVeisited);
				}
			}
		}
	}
}
