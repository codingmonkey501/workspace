package interview.leetcode;

import java.util.ArrayList;

public class BinaryTreeLevelOrderTraversal {

	
	/**
	 * 
			Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
			
			For example:
			Given binary tree {3,9,20,#,#,15,7},
			    3
			   / \
			  9  20
			    /  \
			   15   7
			return its level order traversal as:
			[
			  [3],
			  [9,20],
			  [15,7]
			]	 
	*/
	public static void main(String[] args) {

	}
	
	
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<TreeNode>> tree = new ArrayList<ArrayList<TreeNode>>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return result;
		ArrayList<TreeNode> treelevel = new ArrayList<TreeNode>();
		treelevel.add(root);
		tree.add(treelevel);
		while (true) {
			ArrayList<TreeNode> last = tree.get(tree.size() - 1);
			ArrayList<TreeNode> newlevel = new ArrayList<TreeNode>();
			for (TreeNode node : last) {
				if (node.left != null)
					newlevel.add(node.left);
				if (node.right != null)
					newlevel.add(node.right);
			}
			if (newlevel.size() == 0)
				break;
			tree.add(newlevel);
		}

		for (ArrayList<TreeNode> l : tree) {
			ArrayList<Integer> newlevel = new ArrayList<Integer>();
			for (TreeNode n : l)
				newlevel.add(n.val);
			result.add(newlevel);
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
