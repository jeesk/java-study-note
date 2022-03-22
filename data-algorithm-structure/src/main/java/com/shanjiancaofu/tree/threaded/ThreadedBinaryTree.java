package com.shanjiancaofu.tree.threaded;

import lombok.Data;

@Data
class ThreadedBinaryTree {
	private ThreadedNode root;
	// 前驱节点
	private ThreadedNode pre = null;


	//重载一把threadedNodes方法
	public void threadedNodes() {
		this.threadedNodes(root);
	}
	//编写对二叉树进行中序线索化的方法

	/**
	 * @param node 就是当前需要线索化的结点
	 */
	public void threadedNodes(ThreadedNode node) {

		//如果node==null, 不能线索化
		if (node == null) {
			return;
		}

		//(一)先线索化左子树
		threadedNodes(node.getLeft());
		//(二)线索化当前结点[有难度]

		//处理当前结点的前驱结点
		//以8结点来理解
		//8结点的.left = null , 8结点的.leftType = 1
		if (node.getLeft() == null) {
			//让当前结点的左指针指向前驱结点
			node.setLeft(pre);
			//修改当前结点的左指针的类型,指向前驱结点
			node.setLeftType(1);
		}

		//处理后继结点
		if (pre != null && pre.getRight() == null) {
			//让前驱结点的右指针指向当前结点
			pre.setRight(node);
			//修改前驱结点的右指针类型
			pre.setRightType(1);
		}
		//!!! 每处理一个结点后，让当前结点是下一个结点的前驱结点
		pre = node;

		//(三)在线索化右子树
		threadedNodes(node.getRight());


	}

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

	public ThreadedNode preOrderSearch(int no) {
		if (this.root != null) {
			return this.root.preOrderSearch(no);
		}
		return null;
	}

	public ThreadedNode infixSearch(int no) {
		if (root != null) {
			return this.root.infixSearch(no);
		}
		return null;
	}

	public ThreadedNode postSearch(int no) {
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


	public void threadedList() {
		// 首先找到左子树为leftType==0 的，
		// 再找到该左子树的右子树遍历
		ThreadedNode node = root;

		//         1
		//     3          6
		//   8    10     14
		//16    18

//		16,8,3, 18,10,1, 14,6
		// 规则是首先找到最左边的节点打印出来, 然后依次遍历出后继节点, 如果发现这个节点的righti不是后继节点,说明该节点有右子树，再按照前面的方法遍历即可
		while (node != null) {
			// 找到最右边的
			while (node.getLeftType() == 0) {
				node = node.getLeft();
			}
			// 遍历左边节点
			System.out.println(String.format("id:%s, name: %s", node.getNo(), node.getName()));
			// 再遍历后继节点
			while (node.getRightType() == 1) {
				node = node.getRight();
				System.out.println(String.format("id:%s, name: %s", node.getNo(), node.getName()));
			}
			// 遍历右边节点
			node = node.getRight();
		}
	}
}

