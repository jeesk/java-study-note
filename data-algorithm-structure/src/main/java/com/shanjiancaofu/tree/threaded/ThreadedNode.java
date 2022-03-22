package com.shanjiancaofu.tree.threaded;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Setter
@Getter
class ThreadedNode {
	private int no;
	private String name;

	// 0 表示为左子树， 1为前驱节点
	private int leftType;
	// 0 表示右子树， 1为后继节点
	private int rightType;
	private ThreadedNode left;
	private ThreadedNode right;

	public ThreadedNode(int no, String name) {
		this.no = no;
		this.name = name;
	}

	// 删除节点
	public void delNode(int no) {
		if (this.left != null && this.left.no == no) {
			this.left = null;
			return;
		}
		if (this.right != null && this.right.no == no) {
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

	public ThreadedNode preOrderSearch(int no) {
		if (this.getNo() == no) {
			return this;
		}

		// 向左便利
		ThreadedNode temNode = null;
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


	public ThreadedNode infixSearch(int no) {
		// 向左便利
		ThreadedNode temNode = null;
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

	public ThreadedNode postSearch(int no) {
		// 向左便利
		ThreadedNode temNode = null;
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
