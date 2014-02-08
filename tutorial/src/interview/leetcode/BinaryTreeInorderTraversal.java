package interview.leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	
	/**
	Given a binary tree, return the inorder traversal of its nodes' values.
	
	For example:
	Given binary tree {1,#,2,3},
	   1
	    \
	     2
	    /
	   3
	return [1,3,2].
	
	Note: Recursive solution is trivial, could you do it iteratively?
	
	confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
	
	
	OJ's Binary Tree Serialization:
	The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
	
	Here's an example:
	   1
	  / \
	 2   3
	    /
	   4
	    \
	     5
	The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".	 
	*/
	
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> arr=new ArrayList<Integer>();
        if(root==null) return arr;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(root);
        TreeNode node=root.left; //wrong here
        while(!stack.isEmpty() || node!=null){ //wrong here: stack is empty but node still has value [1,#,2]
            
            while(node!=null){ 
                stack.push(node); //wrong here: should not be node.left because that have not been checked yet
                node=node.left;
            }
            node=stack.pop();
            arr.add(node.val);
            node=node.right;
        }
        return arr;
    }
	
	/**
	 * recusive way
	 */
	public ArrayList<Integer> preorderTraversal2(TreeNode root) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		inorder(root, arr);
		return arr;

	}
	
	public void inorder(TreeNode node, ArrayList<Integer> arr) {
		if (node == null)
			return;
		
		inorder(node.left, arr);
		arr.add(node.val);
		inorder(node.right, arr);
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
