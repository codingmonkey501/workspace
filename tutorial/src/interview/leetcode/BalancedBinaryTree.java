package interview.leetcode;


public class BalancedBinaryTree {

	/**
	 * Given a binary tree, determine if it is height-balanced.

		For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
	 */
	public static void main(String[] args) {
	}
	
	
	public boolean isBalanced(TreeNode root) {
        //no 2 leaf nodes differ in distance from the root by more than 1
        // int max=recusiveMax(root);
        // int min=recusiveMin(root); //should start from 0
        // if(Math.abs(max-min)>1) return false;
        // return true;
        
        if (root == null) return true;
        //two subtrees of every node never differ by more than 1
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (Math.abs(left - right) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    
    private int getHeight(TreeNode n) {
        if (n == null) return 0;
    
        return Math.max(getHeight(n.left), getHeight(n.right)) + 1;
    }
    
    public int recusiveMax(TreeNode node){
        if(node==null) return 0;
        return  1+Math.max(recusiveMax(node.left), recusiveMax(node.right));
    }
    
    public int recusiveMin(TreeNode node){
        if(node==null) return 0;
        return  1+Math.min(recusiveMin(node.left), recusiveMin(node.right));
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
