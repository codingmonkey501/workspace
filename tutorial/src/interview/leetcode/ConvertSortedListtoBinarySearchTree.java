package interview.leetcode;

import interview.leetcode.AddTwoNumbers.ListNode;

public class ConvertSortedListtoBinarySearchTree {
	/**
	  Given a singly linked list where elements are sorted in ascending order,
	  convert it to a height balanced BST.
	 */
	public static void main(String[] args) {

	}
	
	public TreeNode sortedListToBST(ListNode head) {
		return sortedListToBST(head, listLength(head));
	}

	private TreeNode sortedListToBST(ListNode head, int len) {
		if (len == 0)
			return null;
		if (len == 1)
			return new TreeNode(head.val);
		TreeNode root = new TreeNode(nthNode(head, len/2+1).val);
		root.left = sortedListToBST(head, len / 2);
		root.right = sortedListToBST(nthNode(head, len/2+2), (len - 1)/2);
		return root;
	}

	private int listLength(ListNode node) {
		int n = 0;
		while (node != null) {
			++n;
			node = node.next;
		}
		return n;
	}

	private ListNode nthNode(ListNode node, int n) {
		while (--n != 0)
			node = node.next;
		return node;
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
