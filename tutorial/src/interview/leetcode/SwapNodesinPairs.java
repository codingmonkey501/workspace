package interview.leetcode;

public class SwapNodesinPairs {

	/**
	 * Given a linked list, swap every two adjacent nodes and return its head.
	 * 
	 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
	 * 
	 * Your algorithm should use only constant space. You may not modify the
	 * values in the list, only nodes itself can be changed.
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

	public ListNode swapPairs(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		ListNode newHead = head.next;
		ListNode curr = head;
		ListNode next = head.next;

		while (next != null) {
			curr.next = next.next;
			next.next = curr;
			ListNode joinpoint = curr; // forget to link the joinpoint between
										// the two nodes
			curr = curr.next;
			if (curr == null)
				break;
			next = curr.next;
			if (next != null)
				joinpoint.next = next; // need to check next!=null when [1,2,3]
		}

		return newHead;
	}
}
