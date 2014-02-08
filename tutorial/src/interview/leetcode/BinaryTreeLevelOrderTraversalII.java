package interview.leetcode;

import java.util.ArrayList;

public class BinaryTreeLevelOrderTraversalII {

	
	/**
	 * 
	 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

		For example:
		Given binary tree {3,9,20,#,#,15,7},
		    3
		   / \
		  9  20
		    /  \
		   15   7
		return its bottom-up level order traversal as:
		[
		  [15,7]
		  [9,20],
		  [3],
		]
	 */
	public static void main(String[] args) {

	}

	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<TreeNode>> treebylevel = new ArrayList<ArrayList<TreeNode>>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return result;
		ArrayList<TreeNode> rootlevel = new ArrayList<TreeNode>();
		rootlevel.add(root);
		treebylevel.add(rootlevel);
		recusive(treebylevel);

		// reverse and output
		for (int i = treebylevel.size(); i > 0; i--) {
			ArrayList<TreeNode> level = treebylevel.get(i - 1);
			ArrayList<Integer> intlevel = new ArrayList<Integer>();
			for (TreeNode n : level) {
				intlevel.add(n.val);
			}
			result.add(intlevel);
		}
		return result;
	}

	public void recusive(ArrayList<ArrayList<TreeNode>> treebylevel) {
		ArrayList<TreeNode> level = treebylevel.get(treebylevel.size() - 1);
		ArrayList<TreeNode> newLevel = new ArrayList<TreeNode>();
		for (TreeNode n : level) {
			if (n.left != null)
				newLevel.add(n.left);
			if (n.right != null)
				newLevel.add(n.right);
		}
		if (newLevel.size() == 0)
			return;
		treebylevel.add(newLevel);
		recusive(treebylevel);
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
