package interview.leetcode;

public class ValidateBinarySearchTree {

	/**
	 * Given a binary tree, determine if it is a valid binary search tree (BST).

		Assume a BST is defined as follows:
		
		The left subtree of a node contains only nodes with keys less than the node's key.
		The right subtree of a node contains only nodes with keys greater than the node's key.
		Both the left and right subtrees must also be binary search trees.
	 */
	
	public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, int lower, int upper) {
        if (root == null) return true;
        return root.val > lower && root.val < upper
            && isValidBST(root.left, lower, root.val)
            && isValidBST(root.right, root.val, upper);
    }

    //wrong answer
    public boolean isValidBST1(TreeNode root) {
        if (root==null) return true;
        return recusive1(root.left, root.val, root.val, true, 0)
            && recusive1(root.right, root.val, root.val, false, 0);
    }
    
    //   3
    // 1   5
    //0 2 4 6
    //   3
    public boolean recusive1(TreeNode node, int parentVal, int limit, boolean isLeft, int status){
        //status -1 :less than    0: uncheck     1: larger than 
        if(node==null) return true;
        if(isLeft){
            if(node.val<parentVal && (status==0 || status==1 && node.val > limit)) 
                return recusive1(node.left, node.val, parentVal, true, 0) 
                    && recusive1(node.right, node.val, parentVal, false, -1);
            else 
                return false;
        }
        else {
            if(node.val>parentVal && (status==0 || status==-1 && node.val < limit))
                return recusive1(node.left, node.val, parentVal, true, 1) 
                    && recusive1(node.right, node.val, parentVal, false, 0);
            else
                return false;
        }
    }
    
    
    
    //left node less than parent and right node larger than parent
    //wrong answer
    public boolean isValidBST2(TreeNode root) {
        if (root==null) return true;
        return recusive2(root.left, root.val, true)
            && recusive2(root.right, root.val, false);
    }
    
    public boolean recusive2(TreeNode node, int val, boolean isLeft){
        if(node==null) return true;
        if(isLeft){
            if(node.val<val) return recusive2(node.left, node.val, true) && recusive2(node.right, node.val, false);
            else return false;
        }
        else {
            if(node.val>val) return recusive2(node.left, node.val, true) && recusive2(node.right, node.val, false);
            else return false;
        }
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
