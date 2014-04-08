package interview.leetcode;

public class FlattenBinaryTreetoLinkedList {

	
	/**
	 * Given a binary tree, flatten it to a linked list in-place.

		For example,
		Given
		
		         1
		        / \
		       2   5
		      / \   \
		     3   4   6
		The flattened tree should look like:
		   1
		    \
		     2
		      \
		       3
		        \
		         4
		          \
		           5
		            \
		             6
		click to show hints.
		
		Hints:
		If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
	 */
	public static void main(String[] args) {
		FlattenBinaryTreetoLinkedList f=new FlattenBinaryTreetoLinkedList();
//		TreeNode root=new TreeNode(1);
//		TreeNode n2=new TreeNode(2);
//		TreeNode n3=new TreeNode(3);
//		root.left=n2;
//		n2.left=n3;
//		f.flatten(root);
//		System.out.println(root.val);
		
		
//		TreeNode root=new TreeNode(1);
//		TreeNode n2=new TreeNode(2);
//		root.right=n2;
//		f.flatten(root);
//		System.out.println(root.val);
		
		
		TreeNode root=new TreeNode(1);
		TreeNode n2=new TreeNode(2);
		TreeNode n3=new TreeNode(3);
		root.right=n2;
		n2.left=n3;
		f.flatten(root);
		System.out.println(root.val);
	}
	
	public void flatten(TreeNode root) {
		if (root == null) return;
		TreeNode tmp = root.right;
		root.right = root.left;
		flatten(root.left);
		root.left=null;
		TreeNode p=root.right;
		if(p!=null){
		    while(p.right!=null){
		        p=p.right;
		    }
		    p.right=tmp; //in case left is not null, should find right-most node and append tmp
		}
		else{
		    root.right=tmp; // in case left is null, right should remain the same
		}
		
		flatten(tmp);

    }
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
