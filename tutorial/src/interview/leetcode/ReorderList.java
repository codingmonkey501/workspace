package interview.leetcode;

import interview.leetcode.AddTwoNumbers.ListNode;

public class ReorderList {

	
	/**
	  Given a singly linked list L: L0→L1→…→Ln-1→Ln,
		reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
		
		You must do this in-place without altering the nodes' values.
		
		For example,
		Given {1,2,3,4}, reorder it to {1,4,2,3}.
	*/
	public static void main(String[] args) {

	}
	
	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;
		ListNode slow = head, fast = head, prev = null;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = null; // cut at middle
		
		slow = reverse(slow);
		
		// merge two lists
		ListNode curr = head;
		while (curr.next != null) {
			ListNode tmp = curr.next;
			curr.next = slow;
			slow = slow.next;
			curr.next.next = tmp;
			curr = tmp;
		}
		curr.next = slow;
	}

	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode prev = head;
		for (ListNode curr = head.next, next = curr.next; curr != null; prev = curr, curr = next, next = (next != null ? next.next
				: null)) {
			curr.next = prev;
		}
		head.next = null;
		return prev;
	}

}
