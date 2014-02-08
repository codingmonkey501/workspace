package interview.leetcode;

public class MergeTwoSortedLists {

	/**
	 * Merge two sorted linked lists and return it as a new list. The new list
	 * should be made by splicing together the nodes of the first two lists.
	 */

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public void merge(ListNode result, ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null)
			return;
		if (l1.val < l2.val) {
			result = l1;
			merge(result.next, l1.next, l2);
		} else {
			result = l2;
			merge(result.next, l1, l2.next);
		}
	}

	public static void main(String[] args) {

	}

}
