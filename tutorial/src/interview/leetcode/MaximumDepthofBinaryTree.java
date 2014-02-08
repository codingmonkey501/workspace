package interview.leetcode;

public class MaximumDepthofBinaryTree {

	/**
	 * Given a binary tree, find its maximum depth.
	 * 
	 * The maximum depth is the number of nodes along the longest path from the
	 * root node down to the farthest leaf node.
	 */
	
	
	public static int maxDepth(TreeNode root) {
		if(root==null) return 0; //should use recusive this way : do not check null pointer in the other places
		int left = maxDepth(root.left);
		int right= maxDepth(root.right);
		return (left>right)? left+1 : right+1; // accumulate in a recusive way
	}
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(1);
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(1);
		TreeNode n6 = new TreeNode(1);
		root.left = n1;
		root.right = n2;
		n1.left = n3;
		n1.right = n4;
		n4.left=n5;
		n4.right=n6;
		System.out.println(maxDepth(root));
	}
	
}
