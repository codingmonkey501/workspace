package interview.leetcode;

public class RotateList {

	/**
	 * Given a list, rotate the list to the right by k places, where k is
	 * non-negative.
	 * 
	 * For example: Given 1->2->3->4->5->NULL and k = 2, return
	 * 4->5->1->2->3->NULL.
	 */
	public static void main(String[] args) {

	}

	public ListNode rotateRight(ListNode head, int n) {
		if (head == null || head.next == null || n == 0)
			return head;

		ListNode endnode = head;
		int size = 1;
		while (endnode.next != null) {
			size++;
			endnode = endnode.next;
		}

		if (n % size == 0)
			return head;
		int k = size - n % size;

		ListNode p = head;
		endnode.next = head; // link head and endnode
		for (int i = 1; i < k; i++) {
			p = p.next;
		}
		head = p.next;
		p.next = null;
		return head;

		// ListNode pre=head;
		// for(int i=1;i<k;i++){ //attention here
		// pre=pre.next;
		// }
		// return rotateRight(pre, head); //attention here

	}

	// bad
	public ListNode rotateRight(ListNode n, ListNode head) {
		if (n.next == null)
			return head;
		ListNode newhead = rotateRight(n.next, head);
		ListNode tmp = n.next;
		n.next.next = newhead;
		n.next = null;
		return tmp;
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
