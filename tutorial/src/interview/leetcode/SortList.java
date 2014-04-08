package interview.leetcode;

public class SortList {

	/**
	 * Sort a linked list in O(n log n) time using constant space complexity.
	 */
	public static void main(String[] args) {
	}

	// double linked list -> use quick sort
	// singlar linked list -> use merge sort
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode fast = head, slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;

			slow = slow.next;
		}
		
		fast = slow; //disconnect the two linked list
		slow = slow.next;
		fast.next = null;
		
		ListNode l1 = sortList(head); 
		ListNode l2 = sortList(slow);	//slow is null if only one node
		return mergeTwoLists(l1, l2);
	}

	// Merge Two Sorted Lists
	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		for (ListNode p = dummy; l1 != null || l2 != null; p = p.next) { //maybe one of the l1 or l2 is null
			int val1 = (l1 == null ? Integer.MAX_VALUE : l1.val); 
			int val2 = (l2 == null ? Integer.MAX_VALUE : l2.val);
			if (val1 <= val2) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
		}
		return dummy.next;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
