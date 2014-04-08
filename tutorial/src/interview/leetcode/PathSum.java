package interview.leetcode;

import interview.leetcode.BalancedBinaryTree.TreeNode;

public class PathSum {

	
	
	/**
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

		For example:
		Given the below binary tree and sum = 22,
		              5
		             / \
		            4   8
		           /   / \
		          11  13  4
		         /  \      \
		        7    2      1
		return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
	 */
	
	
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        return recusive(root, 0, sum);
    }
    
    public boolean recusive(TreeNode node, int s, int sum){
        if(node==null) return false;
        s+=node.val;
        if(node.left==null && node.right==null && s==sum) return true;// what if it is not a complete tree {1,2}, 1: check if it a leaf node
        return (recusive(node.left, s, sum) || recusive(node.right, s, sum));
    }
}
