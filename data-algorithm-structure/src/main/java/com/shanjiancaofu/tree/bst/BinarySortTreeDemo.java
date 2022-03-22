package com.shanjiancaofu.tree.bst;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class BinarySortTreeDemo {
	public static void main(String[] args) {
		Node node1 = new Node(7);
		Node node2 = new Node(3);
		Node node3 = new Node(10);
		Node node4 = new Node(12);
		Node node5 = new Node(5);
		Node node10 = new Node(5);
		Node node44 = new Node(4);
		Node node6 = new Node(1);

		Node node7 = new Node(9);
		Node node8 = new Node(0);
		BinarySortTree binarySortTree = new BinarySortTree();
		binarySortTree.add(node1);
		binarySortTree.add(node2);
		binarySortTree.add(node3);
		binarySortTree.add(node4);
		binarySortTree.add(node5);
		binarySortTree.add(node6);
		binarySortTree.add(node7);
		binarySortTree.add(node8);
		binarySortTree.add(node10);
		binarySortTree.add(node44);
		binarySortTree.deleteNode(5);
		binarySortTree.infixIOrder();
		System.out.println("");
	}

	@Getter
	@Setter
	public static class BinarySortTree {
		private Node root;

		public Node search(int value) {
			if (root == null) {
				return null;
			}
			return root.search(value);
		}


		public Node searchParent(int value) {
			if (root == null) {
				return null;
			}
			return root.parentSearch(value);
		}

		/**
		 * @param node 二叉树的根(传入目标节点右子节点）
		 * @return 最小节点的值
		 */
		public int delRightTreeMin(Node node) {
			Node target = node;
			// 找到左边最小人值
			while (target.left != null) {
				target = target.left;
			}
			deleteNode(target.value);
			return target.value;
		}
		public void deleteNode(int valule) {
			if (root == null) {
				return;
			}
			Node targetNode = search(valule);
			if (targetNode == null) {
				System.out.println("找不到该node");
				return;
			}
			Node parentNode = searchParent(targetNode.getValue());
			if (parentNode == null) {
				//有2 个子节点
				if (targetNode.left != null && targetNode.right != null) {
					// 找到左边最大的修值
					Node tempNode = targetNode.getRight();
					this.root.value = delRightTreeMin(tempNode);
				} else if (targetNode.left == null && targetNode.right == null) {
					this.root = null;
				} else {
					if (targetNode.left != null) {
						this.root = targetNode.left;
					} else {
						this.root = targetNode.right;
					}
				}
				// 有2个子节点
			} else {
				boolean hasLeft = targetNode.getLeft() != null;
				boolean hasRight = targetNode.getRight() != null;

				// 是叶子节点
				if (targetNode.left == null && targetNode.right == null) {
					if (parentNode.getLeft() != null && parentNode.getLeft().getValue() == valule) {
						parentNode.left = null;
					} else if (parentNode.getRight() != null && parentNode.getRight().getValue() == valule) {
						parentNode.right = null;
					}

				} else if (hasLeft && hasRight) {
					// 目标节点有两个节点
					targetNode.value = delRightTreeMin(targetNode.getRight());
				} else {
					// 目标节点有一个节点
					// 如果目标节点有左子节点
					if (targetNode.getLeft() != null) {
						if (parentNode.left.getValue() == targetNode.getValue()) {
							parentNode.left = targetNode.left;
						} else {
							parentNode.right = targetNode.left;
						}
					} else {
						// 如果目标节点右边节点
						if (parentNode.left.getValue() == targetNode.getValue()) {
							parentNode.left = targetNode.right;
						} else {
							parentNode.right = targetNode.right;
						}
					}
				}
			}
		}

		public void add(Node addNode) {
			if (this.root == null) {
				this.root = addNode;
			} else {
				this.root.add(addNode);
			}
		}

		public void infixIOrder() {
			if (root != null) {
				root.infixOrder();
			} else {
				System.out.println("根节点为空");
			}
		}
	}


	@ToString(exclude = {"left", "right"})
	@Getter
	@Setter
	public static class Node {
		private int value;
		private Node left;
		private Node right;

		public Node(int value) {
			this.value = value;
		}


		public Node parentSearch(int value) {
			boolean isLeftNode = this.left != null && this.getLeft().getValue() == value;
			boolean isRightNode = this.right != null && this.getRight().getValue() == value;
			if (isLeftNode || isRightNode) {
				return this;
			} else {
				if (value < this.getValue() && this.left != null) {
					return this.left.parentSearch(value);
				}
				if (value >= this.getValue() && this.right != null) {
					return this.right.parentSearch(value);
				}
				// 找不到
				return null;

			}
		}

		public Node search(int value) {
			if (value == this.getValue()) {
				return this;
			}
			if (value < this.getValue()) {
				if (this.getLeft() == null) {
					return null;
				}
				return this.getLeft().search(value);
			} else {
				if (this.getRight() == null) {
					return null;
				}
				return this.getRight().search(value);
			}
		}

		public void add(Node node) {
			if (node == null) {
				System.out.println("node is null");
				return;
			}
			if (node.getValue() < this.value) {
				if (getLeft() == null) {
					setLeft(node);
				} else {
					getLeft().add(node);
				}
			} else {
				// 大于和相等的时候在右边
				if (getRight() == null) {
					setRight(node);
				} else {
					getRight().add(node);
				}
			}
		}


		/**
		 * 中序遍历
		 */
		public void infixOrder() {
			if (getLeft() != null) {
				getLeft().infixOrder();
			}
			System.out.println(this);
			if (getRight() != null) {
				getRight().infixOrder();
			}
		}
	}
}
