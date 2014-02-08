package interview.leetcode;

public class RemoveDuplicatesfromSortedList {
	
	/**
	 * Given a sorted linked list, delete all duplicates such that each element appear only once.

		For example,
		Given 1->1->2, return 1->2.
		Given 1->1->2->3->3, return 1->2->3.
	 */
	public static void main(String[] args) {
	}

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		ListNode last = head;
		ListNode curr = head.next;
		while (curr != null) {
			if (curr.val == last.val) {
				last.next = null;
			} else {
				last.next = curr;
				last = last.next;
			}
			curr = curr.next;
		}
		return head;

		// 1
		// null
		// 1,1
		// 1,2
		// 1,1,2
		// 1,1,2,2
	}

}
