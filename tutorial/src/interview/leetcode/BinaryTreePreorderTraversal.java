package interview.leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	
	/**
	 * Given a binary tree, return the preorder traversal of its nodes' values.

		For example:
		Given binary tree {1,#,2,3},
		   1
		    \
		     2
		    /
		   3
		return [1,2,3].
		
		Note: Recursive solution is trivial, could you do it iteratively?
	 */
	
	/**
	*/
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
	    if(root==null) return arr;
	    
	    Stack<TreeNode> leftStack = new Stack<TreeNode>();
	    Stack<TreeNode> rightStack = new Stack<TreeNode>();
	    TreeNode node=root;
	    leftStack.push(node);
	    while(!leftStack.isEmpty() || !rightStack.isEmpty()){
	        
	        if (!leftStack.isEmpty()) node=leftStack.pop();
	        else node=rightStack.pop();
	        arr.add(node.val);
	        
	        if(node.left!=null)
	            leftStack.push(node.left);
	        if(node.right!=null)
	            rightStack.push(node.right);
	    }
	    return arr;
	}
	
	/**
	 * recusive way
	 */
	public ArrayList<Integer> preorderTraversal2(TreeNode root) {

		ArrayList<Integer> arr = new ArrayList<Integer>();
		pre(root, arr);
		return arr;

	}
	
	public void pre(TreeNode node, ArrayList<Integer> arr) {
		if (node == null)
			return;
		arr.add(node.val);
		pre(node.left, arr);
		pre(node.right, arr);
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
			
	public static void main(String[] args) {

	}

}
