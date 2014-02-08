package interview.leetcode;

public class PopulatingNextRightPointersinEachNode {

	/**
	 * 
	 * Given a binary tree

	    struct TreeLinkNode {
	      TreeLinkNode *left;
	      TreeLinkNode *right;
	      TreeLinkNode *next;
	    }
		Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
		
		Initially, all next pointers are set to NULL.
		
		Note:
		
		You may only use constant extra space.
		You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
		For example,
		Given the following perfect binary tree,
		         1
		       /  \
		      2    3
		     / \  / \
		    4  5  6  7
		After calling your function, the tree should look like:
		         1 -> NULL
		       /  \
		      2 -> 3 -> NULL
		     / \  / \
		    4->5->6->7 -> NULL
	 * 
	 * 
	 */
	
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) {
			val = x;
		}
	}
	
	public void connect(TreeLinkNode root) {

		if (root == null)
			return;

		// check depth
		TreeLinkNode node = root;   //only one root the depth will be 1
		int depth = 0;
		while (node != null) {
			depth++;
			node = node.left;
		}
		
		//caculate size
		int size = 1;
		for (int i = 0; i < depth; i++) {
			size *= 2;
		}
		size= size - 1;//the real size should be size - 1
		
		//init arr
		TreeLinkNode[] arr = new TreeLinkNode[size]; 
		int curr = 0;
		arr[curr] = root;
		root.next = null;
		int next = 1;
		int base = 2;
		
		//assign arr and link each node
		while (next < size) {
			arr[next++] = arr[curr].left;
			if (next != base) {
				arr[next - 2].next = arr[next - 1];
			}
			arr[next++] = arr[curr].right;
			arr[next - 2].next = arr[next - 1];
			if (curr + 2 == base) {
				arr[curr].next = null;
				base *= 2;
			}
			curr++;
		}
	}
	
	/**
	 * good without additional space
	 */
	public void connect2(TreeLinkNode root){
		re(root.left, root.right);
	}
	
	public void re(TreeLinkNode left, TreeLinkNode right) {
		if (left == null || right == null)
			return;
		left.next = right;
		re(left.left, left.right);
		re(left.right, right.left);
		re(right.left, right.right);
	}
	
	public static void main(String[] args) {

	}

}
