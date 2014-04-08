package interview.leetcode;

import interview.leetcode.BalancedBinaryTree.TreeNode;

public class RecoverBinarySearchTree {

	
	/**
	 * Two elements of a binary search tree (BST) are swapped by mistake.

		Recover the tree without changing its structure.
		
		Note:
		A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
		confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
	 */
	public static void main(String[] args) {
	}
	
	
	
	public void recoverTree(TreeNode root) {
		Pair pair=new Pair();
		TreeNode prev = null;
		
		//morris inorder traverse tree 
		TreeNode curr = root;
		while (curr != null) {
			if (curr.left == null) {
				detect(pair, prev, curr);
				prev = curr;
				curr = curr.right; //traverse to next bigger one
			} else {
			
				TreeNode node = curr.left;
				while (node.right != null && node.right != curr)
					node = node.right;
				
				if (node.right == null) {
					node.right = curr; //link
					curr = curr.left;
				} else {
					detect(pair, prev, curr);
					node.right = null; //broken
					prev = curr;
					curr = curr.right;
				}
			}
		}
		swap(pair);
			
    }

	public void detect(Pair broken, TreeNode prev, TreeNode current) {
		if (prev != null && prev.val > current.val) {
			if (broken.first == null) {
				broken.first = prev;
			}
			
			broken.second = current;
		}
	}
	
	public void swap(Pair broken){
		int tmp=broken.first.val;
		broken.first.val=broken.second.val;
		broken.second.val=tmp;
	}
	
	class Pair{
		TreeNode first;
		TreeNode second;
	}
}
