package interview.leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

	/**
	 * Given a binary tree, return the postorder traversal of its nodes' values.
	 * 
	 * For example: Given binary tree {1,#,2,3}, 1 \ 2 / 3 return [3,2,1].
	 * 
	 * Note: Recursive solution is trivial, could you do it iteratively?
	 */
	public static void main(String[] args) {

	}

	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		Stack<TreeNode> stack = new Stack<TreeNode>();

		stack.push(root);
		TreeNode node = stack.peek();
		TreeNode last = null;
		while (!stack.isEmpty()) {
			while (node != null) {
				if (node.left != null)
					stack.push(node.left);
				node = node.left;
			}
			node = stack.peek();
			if (node.right != last && node.right != null) { // node.right!=last
															// to check it is
															// not from right
															// and to prevent
															// from eternal loop
				stack.push(node.right);
				node = node.right;
			} else {
				last = stack.pop();
				result.add(last.val);
				node = null;
			}
		}
		return result;
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
