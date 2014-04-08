package interview.leetcode;

public class ReverseNodesinkGroup {

	/**
	 * Given a linked list, reverse the nodes of a linked list k at a time and
	 * return its modified list.
	 * 
	 * If the number of nodes is not a multiple of k then left-out nodes in the
	 * end should remain as it is.
	 * 
	 * You may not alter the values in the nodes, only nodes itself may be
	 * changed.
	 * 
	 * Only constant memory is allowed.
	 * 
	 * For example, Given this linked list: 1->2->3->4->5
	 * 
	 * For k = 2, you should return: 2->1->4->3->5
	 * 
	 * For k = 3, you should return: 3->2->1->4->5
	 */
	public static void main(String[] args) {

	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null || k < 2)
			return head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		for (ListNode prev = dummy, end = head; end != null; end = prev.next) {
			for (int i = 1; i < k && end != null; i++)
				end = end.next;
			if (end == null)
				break; // not reach k
			prev = reverse(prev, prev.next, end);
		}
		return dummy.next;
	}

	// prev in the ele before first, [begin, end] is close area,none of the
	// three is null
	// return the first ele after reverse
	public ListNode reverse(ListNode prev, ListNode begin, ListNode end) {
		ListNode end_next = end.next;
		for (ListNode p = begin, cur = p.next, next = cur.next;
				cur != end_next;
				p = cur, cur = next, next = (next != null ? next.next : null)) {
			
			cur.next = p;
		}
		begin.next = end_next;
		prev.next = end;
		return begin;
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
