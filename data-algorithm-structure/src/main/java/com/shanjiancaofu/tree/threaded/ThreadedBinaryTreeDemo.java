package com.shanjiancaofu.tree.threaded;

public class ThreadedBinaryTreeDemo {

	public static void main(String[] args) {
		ThreadedNode root = new ThreadedNode(1, "tom");
		ThreadedNode node2 = new ThreadedNode(3, "jack");
		ThreadedNode node3 = new ThreadedNode(6, "smith");
		ThreadedNode node4 = new ThreadedNode(8, "mary");
		ThreadedNode node5 = new ThreadedNode(10, "king");
		ThreadedNode node6 = new ThreadedNode(14, "dim");
		ThreadedNode node7 = new ThreadedNode(16, "dim");
		ThreadedNode node8 = new ThreadedNode(18, "dim");

		//二叉树，后面我们要递归创建, 现在简单处理使用手动创建
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		node4.setLeft(node7);
		node5.setLeft(node8);

		//测试中序线索化
		ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
		threadedBinaryTree.setRoot(root);
		//threadedBinaryTree.infixOrder(); //
		threadedBinaryTree.threadedNodes();
		threadedBinaryTree.threadedList();
		System.out.println();

	}
}


