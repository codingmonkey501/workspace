package interview.leetcode;

import java.util.LinkedList;
import java.util.Stack;

public class SymmetricTree {

	/**
	 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

		For example, this binary tree is symmetric:
		
		    1
		   / \
		  2   2
		 / \ / \
		3  4 4  3
		But the following is not:
		    1
		   / \
		  2   2
		   \   \
		   3    3
		Note:
		Bonus points if you could solve it both recursively and iteratively.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isSymmetric(TreeNode root) {

		if (root == null)
			return true;
		// return recusively(root.left, root.right);
		return iteratively(root);
	}

	public boolean recusively(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left != null && right != null && left.val == right.val) { // wrong
																		// here
																		// forget
																		// to
																		// check
																		// null
			return recusively(left.left, right.right)
					&& recusively(left.right, right.left);
		}
		return false;
	}

	// here may be stack is not good structure because stack need always check
	// null before add
	public boolean iteratively2(TreeNode root) {

		Stack<TreeNode> left = new Stack<TreeNode>();
		Stack<TreeNode> right = new Stack<TreeNode>();
		TreeNode n1 = root.left;
		TreeNode n2 = root.right;
		if (n1 != null && n2 != null) {
			left.push(n1); // push and pop
			right.push(n2);
			if (n1.val != n2.val)
				return false;// check for [1,2,3]
		} else if (n1 != n2) {
			return false;
		}
		while (!left.isEmpty() && !right.isEmpty()) {
			n1 = left.pop();
			n2 = right.pop();
			if (n1.left != null && n2.right != null) { // check n1's left and
														// n2's right
				left.push(n1.left);
				right.push(n2.right);
				if (n1.left.val != n2.right.val)
					return false; // check the equality when pop is not working
									// for senario [1,2,2,#,3,#,3]
			} else if (n1.left != n2.right) {
				return false;
			}
			if (n1.right != null && n2.left != null) {
				left.push(n1.right);
				right.push(n2.left);
				if (n1.right.val != n2.left.val)
					return false;
			} else if (n1.right != n2.left) {
				return false;
			}
		}
		if (!left.isEmpty() || !right.isEmpty())
			return false;
		return true;
	}

	// wrong answer
	public boolean iterativelywrong(TreeNode root) {

		Stack<TreeNode> left = new Stack<TreeNode>();
		Stack<TreeNode> right = new Stack<TreeNode>();
		TreeNode n1 = root.left;
		TreeNode n2 = root.right;
		if (n1 != null)
			left.push(n1); // push and pop
		if (n2 != null)
			right.push(n2);
		while (!left.isEmpty() && !right.isEmpty()) {
			n1 = left.pop();
			n2 = right.pop();
			if (n1 == null && n2 != null || n2 == null && n1 != null
					|| n1.val != n2.val)
				return false; // check the equality when pop is not working for
								// senario [1,2,2,#,3,#,3]
			if (n1.left != null)
				left.push(n1.left);
			if (n1.right != null)
				right.push(n2.right);
			if (n2.right != null)
				left.push(n1.right);
			if (n2.left != null)
				right.push(n2.left);
		}
		if (!left.isEmpty() || !right.isEmpty())
			return false;
		return true;
	}

	public boolean iteratively(TreeNode root) {
		if (root == null)
			return true;
		LinkedList<TreeNode> l = new LinkedList<TreeNode>(), r = new LinkedList<TreeNode>();
		l.add(root.left); // can add null value? yes. size will increased 1
		r.add(root.right);
		while (!l.isEmpty() && !r.isEmpty()) {
			TreeNode temp1 = l.poll(), // add and poll method
			temp2 = r.poll();
			if (temp1 == null && temp2 != null || temp1 != null
					&& temp2 == null)
				return false;
			if (temp1 != null) {
				if (temp1.val != temp2.val)
					return false; // [1] will throw null pointer exception if
									// this line put into lin97
				l.add(temp1.left);
				l.add(temp1.right);
				r.add(temp2.right);
				r.add(temp2.left);
			}
		}
		return true;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
