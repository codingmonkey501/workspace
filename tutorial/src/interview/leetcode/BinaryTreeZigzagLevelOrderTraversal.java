package interview.leetcode;

import interview.leetcode.BalancedBinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

	
	/**
	 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

		For example:
		Given binary tree {3,9,20,#,#,15,7},
		    3
		   / \
		  9  20
		    /  \
		   15   7
		return its zigzag level order traversal as:
		[
		  [3],
		  [20,9],
		  [15,7]
		]
		confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
	 */
	public static void main(String[] args) {
	}
	
	// recursive
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		traverse(root, 1, result, true);
		return result;
	}

	private void traverse(TreeNode root, int level, ArrayList<ArrayList<Integer>> result, boolean left_to_right) {
		if (root == null)
			return;

		if (level > result.size())
			result.add(new ArrayList<Integer>());

		if (left_to_right)
			result.get(level - 1).add(root.val);
		else
			result.get(level - 1).add(0, root.val); //insert node at front

		traverse(root.left, level + 1, result, !left_to_right);
		traverse(root.right, level + 1, result, !left_to_right);
	}
	
	// iteration
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder2(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (null == root)
			return result;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		boolean left_to_right = true; // left to right
		ArrayList<Integer> level = new ArrayList<Integer>(); // one level's
																// elements
		q.add(root);
		q.add(null); // level separator
		while (!q.isEmpty()) {
			TreeNode cur = q.peek();
			q.poll();
			if (cur != null) {
				level.add(cur.val);
				if (cur.left != null)
					q.add(cur.left);
				if (cur.right != null)
					q.add(cur.right);
			} else {
				if (left_to_right) {
					ArrayList<Integer> r = new ArrayList<Integer>(level);
					result.add(r);
				} else {
					ArrayList<Integer> r = new ArrayList<Integer>(level);
					Collections.reverse(r);
					result.add(r);
				}

				level.clear();
				left_to_right = !left_to_right;
				if (q.size() > 0)
					q.add(null);
			}
		}
		return result;
	}

}
