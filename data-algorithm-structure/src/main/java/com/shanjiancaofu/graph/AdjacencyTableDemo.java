package com.shanjiancaofu.graph;

import lombok.Data;

public class AdjacencyTableDemo {


	public static class AdjacencyTable<T> {
		private Linked<T> linked;
	}


	@Data
	public class Linked<T> {
		Node<T> node;
		int size;

		public Linked(int size) {
			this.size = size;
		}
	}

	@Data
	public static class Node<T> {
		// 元素数据(权重）
		private T t;
		// 下一个节点
		private Node<T> next;

		public Node(T t) {
			this.t = t;
		}
	}
}
