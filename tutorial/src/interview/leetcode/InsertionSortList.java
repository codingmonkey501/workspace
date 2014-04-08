package interview.leetcode;

public class InsertionSortList {

	
	/**
	 * Sort a linked list using insertion sort.
	 */
	
	// [-2147483647,-2147483648]
	// pos!=cur will have infinite loop for case [1, 1], 1 always swap with
	// another 1
	// in case of [1] the cursor and pos point to same node, then do not need to
	// swap nodes
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
		for (ListNode cur = head; cur != null;) {
			ListNode temp = cur.next;
			ListNode ins = findInsertPlace(dummyHead, cur.val);
			cur.next = ins.next; // [1] ins will be dummyhead and next will be
									// null
			ins.next = cur; // [1, 1] will break into two list: one is [dummy ->
							// 1 -> null] another will be [temp/1 -> null]
			cur = temp;
		}
		return dummyHead.next;
	}

	public ListNode findInsertPlace(ListNode head, int val) {
		while (head.next != null && head.next.val <= val) {
			head = head.next;
		}
		return head;
	}
    
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
