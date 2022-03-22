package com.shanjiancaofu.tree.huffmantree;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 所有的叶子节点到的带权路径长度最小
 */
public class HuffmanTree {
	public static void main(String[] args) {
		int[] arr = {13, 7, 8, 2};
		Node huffmanTree = createHuffmanTree(arr);
		huffmanTree.preOreder();
	}


	public static Node createHuffmanTree(int[] arr) {
		List<Node> nodes = new ArrayList<>(arr.length);
		for (int i = 0; i < arr.length; i++) {
			nodes.add(new Node(arr[i]));
		}
		while (nodes.size() > 1) {
			nodes.sort(Comparator.comparingInt(Node::getValue));
			Node leftNode = nodes.get(0);
			Node rightNode = nodes.get(1);
			Node parentNode = new Node(leftNode.getValue() + rightNode.getValue());
			parentNode.setLeft(leftNode);
			parentNode.setRight(rightNode);
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			nodes.add(parentNode);
		}
		return nodes.get(0);
	}
}

@Setter
@Getter
@ToString(exclude = {"left", "right"})
class Node {
	private int value;
	private Node left;
	private Node right;

	public Node(int value) {
		this.value = value;
	}

	public void preOreder() {
		System.out.println(this);
		if (this.left != null) {
			this.left.preOreder();
		}
		if (this.right != null) {
			this.right.preOreder();
		}
	}

}
