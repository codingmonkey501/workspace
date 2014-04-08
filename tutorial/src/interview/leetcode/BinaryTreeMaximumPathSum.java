package interview.leetcode;

import interview.leetcode.BalancedBinaryTree.TreeNode;

public class BinaryTreeMaximumPathSum {

	
	/**
	 * Given a binary tree, find the maximum path sum.

		The path may start and end at any node in the tree.
		
		For example:
		Given the below binary tree,
		
		       1
		      / \
		     2   3
		Return 6.
	 */
	public static void main(String[] args) {

	}
	int maxsum = Integer.MIN_VALUE;

	/**
	 *     1
	 *    /
	 *  -2
	 *  should return 1
	 *  	1
	 *     /
	 *    -2
	 *   /
	 *  5
	 *  should return 5
	 *  
	 *      4
	 *     /
	 *    -2
	 *   /	\
	 *  5    -1
	 *  should return 7
	 * 
	 * 
	 */
	public int maxPathSum(TreeNode root) {
		postorder(root);
		return maxsum;
	}

	private int postorder(TreeNode root) {
		if (root == null)
			return 0;
		int l = postorder(root.left);
		int r = postorder(root.right);
		
		int sum = root.val;
		if (l > 0)
			sum += l;
		if (r > 0)
			sum += r;
		maxsum = Math.max(maxsum, sum);
		return Math.max(r, l) > 0 ? Math.max(r, l) + root.val : root.val;
	}

}
