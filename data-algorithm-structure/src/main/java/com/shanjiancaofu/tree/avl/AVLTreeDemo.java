package com.shanjiancaofu.tree.avl;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class AVLTreeDemo {
	public static void main(String[] args) {

		//int arr[] = {4, 3, 6, 5, 7, 8};
		int arr[] = {6, 7, 89, 10, 12, 1};
		AVLTree aVLTree = new AVLTree();
		for (int value : arr) {
			aVLTree.add(new Node(value));
		}
		aVLTree.infixIOrder();
		System.out.println("");

	}

	@Getter
	@Setter
	public static class AVLTree {
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

		public int getLeftHeight() {
			return left == null ? 0 : left.getHeight();
		}

		public int getRightHeight() {
			return right == null ? 0 : right.getHeight();
		}

		public int getHeight() {
			return Math.max(left == null ? 0 : left.getHeight(), right == null ? 0 : right.getHeight()) + 1;
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

			// 右子树长度长， 左边子树旋转
			if (getRightHeight() - getLeftHeight() > 1) {
				// 右子树的右子树的高度小于右子树的左子树高度， 那么先右旋转
				if (right != null && right.getRightHeight() < right.getLeftHeight()) {
					right.rightRoute();
					leftRoute();
				} else {
					leftRoute();
				}
				return;
			}
			// 左子树高度- 右子树高度 > 1， 向右旋转
			if (getLeftHeight() - getRightHeight() > 1) {
				// 右子树的左子树的高度小于左子树的左子树高度， 那么先右旋转
				if (left != null && left.getLeftHeight() < left.getRightHeight()) {
					// 相对左子树旋转
					left.leftRoute();
					// 再右旋转
					rightRoute();
				} else {
					//右旋转
					rightRoute();
				}
			}
		}

		/**
		 * 左旋转
		 */
		private void leftRoute() {
			// 创建一个新的节点
			Node newNode = new Node(value);
			// 将新节点的左子树设置为左子树
			newNode.left = left;
			// 将新节点的右子树设置为右子树的左子树
			newNode.setRight(right.left);
			// 将当前节点的value 设置为右子树的值
			value = right.getValue();
			// 将当前右子树的设置为右子树的右子树
			right = right.right;
			// 最后连接2树， 将当前节点的左子树设置为新节点
			left = newNode;
		}


		/**
		 * 右旋转旋转
		 */
		private void rightRoute() {
			Node newNode = new Node(value);
			newNode.right = right;
			newNode.setLeft(left.right);
			value = left.getValue();
			left = left.left;
			right = newNode;
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
