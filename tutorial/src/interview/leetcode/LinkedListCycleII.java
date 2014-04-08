package interview.leetcode;

public class LinkedListCycleII {

	/**
	 * Given a linked list, return the node where the cycle begins. If there is
	 * no cycle, return null.
	 * 
	 * Follow up: Can you solve it without using extra space?
	 */
	public static void main(String[] args) {

	}

	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;
		ListNode first = head;
		ListNode second = head;
		while (first != null && second != null) {
			first = first.next;
			if (first == null)
				break;
			first = first.next;
			second = second.next;
			if (first == second)
				break; // wrong here: should not put this condition into
		}
		if (first == null || second == null)
			return null;
		second = head;
		while (second != first) {
			second = second.next;
			first = first.next;
		}
		return first;
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
