package com.shanjiancaofu.search;

import lombok.AllArgsConstructor;
import lombok.Data;

public class BinaryTreeDemo {

	public static void main(String[] args) {
		Node node1 = new Node(1, "宋江");
		Node node2 = new Node(2, "武松");
		Node node3 = new Node(3, "吴勇");
		Node node4 = new Node(4, "哎1");
		Node node5 = new Node(5, "哎5");
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.setRoot(node1);

		node1.setLeft(node2);
		node1.setRight(node3);

		node3.setRight(node4);
		node3.setLeft(node5);
		/*
		binaryTree.preOrder();
		System.out.println();
		binaryTree.infixOrder();
		System.out.println();
		binaryTree.postOrder();
		System.out.println();
		System.out.println(binaryTree.preOrderSearch(1));
		System.out.println(binaryTree.infixSearch(1));
		System.out.println(binaryTree.postSearch(1));*/

		binaryTree.delNode(5);
		binaryTree.preOrder();

		System.out.println();

	}
}

@Data
class BinaryTree {
	private Node root;

	public void preOrder() {
		if (this.root != null) {
			this.root.preOrder();
		}
	}

	public void infixOrder() {
		if (root != null) {
			this.root.infixOrder();
		}
	}

	public void postOrder() {
		if (root != null) {
			this.root.postOrder();
		}
	}

	public Node preOrderSearch(int no) {
		if (this.root != null) {
			return this.root.preOrderSearch(no);
		}
		return null;
	}

	public Node infixSearch(int no) {
		if (root != null) {
			return this.root.infixSearch(no);
		}
		return null;
	}

	public Node postSearch(int no) {
		if (root != null) {
			return this.root.postSearch(no);
		}
		return null;
	}

	// 一个删除

	public void delNode(int no) {
		if (root != null) {
			if (root.getNo() == no) {
				this.root = null;
			} else {
				this.root.delNode(no);
			}
		} else {
			System.out.println("该节点为空");
		}
	}
}

@Data
@AllArgsConstructor
class Node {
	private int no;
	private String name;

	public Node(int no, String name) {
		this.no = no;
		this.name = name;
	}

	private Node left;
	private Node right;

	// 删除节点
	public void delNode(int no) {
		if (this.left != null && this.left.getNo() == no) {
			this.left = null;
			return;
		}
		if (this.right != null && this.right.getNo() == no) {
			this.right = null;
			return;
		}
		// 左右节点都不符合条件, 那么继续递归左右删除
		if (this.left != null) {
			this.left.delNode(no);
		}
		if (this.right != null) {
			this.right.delNode(no);
		}
	}

	// 前序遍历
	public void preOrder() {
		System.out.print(this.getNo() + ",");
		if (this.getLeft() != null) {
			this.getLeft().preOrder();
		}
		if (this.getRight() != null) {
			this.getRight().preOrder();
		}

	}

	// 中序遍历
	public void infixOrder() {
		if (this.getLeft() != null) {
			this.getLeft().infixOrder();
		}
		System.out.print(this.getNo() + ",");
		if (this.getRight() != null) {
			this.getRight().infixOrder();
		}
	}

	// 后续遍历
	public void postOrder() {
		if (this.getLeft() != null) {
			this.getLeft().postOrder();
		}
		if (this.getRight() != null) {
			this.getRight().postOrder();
		}
		System.out.print(this.getNo() + ",");
	}

	public Node preOrderSearch(int no) {
		if (this.getNo() == no) {
			return this;
		}

		// 向左便利
		Node temNode = null;
		if (this.getLeft() != null) {
			temNode = this.getLeft().preOrderSearch(no);
			if (temNode != null) {
				return temNode;
			}
		}
		if (this.getRight() != null) {
			temNode = this.getRight().preOrderSearch(no);
		}
		return temNode;
	}


	public Node infixSearch(int no) {
		// 向左便利
		Node temNode = null;
		if (this.getLeft() != null) {
			temNode = this.getLeft().infixSearch(no);
			if (temNode != null) {
				return temNode;
			}
		}
		if (this.getNo() == no) {
			return this;
		}
		if (this.getRight() != null) {
			temNode = this.getRight().infixSearch(no);
		}
		return temNode;
	}

	public Node postSearch(int no) {
		// 向左便利
		Node temNode = null;
		if (this.getLeft() != null) {
			temNode = this.getLeft().postSearch(no);
			if (temNode != null) {
				return temNode;
			}
		}

		if (this.getRight() != null) {
			temNode = this.getRight().postSearch(no);
		}
		if (this.getNo() == no) {
			return this;
		}
		return temNode;
	}
}
