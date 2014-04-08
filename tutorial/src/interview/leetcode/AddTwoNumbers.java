package interview.leetcode;


public class AddTwoNumbers {

	
	
	/**
	 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
		
		Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
		Output: 7 -> 0 -> 8
	 */
	public static void main(String[] args) {

		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;

		ListNode b1 = new ListNode(5);
		ListNode b2 = new ListNode(6);
		ListNode b3 = new ListNode(4);
		b1.next = b2;
		b2.next = b3;

		AddTwoNumbers a = new AddTwoNumbers();
		ListNode r = a.addTwoNumbers(n1, b1);
		System.out.println(r);

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode dummy = new ListNode(0);
		ListNode p = dummy;

		boolean overflow = false;
		while (l1 != null || l2 != null) {
			int sum = 0;

			if (l1 == null) {
				sum = l2.val;
				l2 = l2.next;
			} else if (l2 == null) {
				sum = l1.val;
				l1 = l1.next;
			} else {
				sum = l1.val + l2.val;
				l1 = l1.next;
				l2 = l2.next;
			}

			if (overflow)
				sum++;
			if (sum >= 10) {
				overflow = true;
				p.next = new ListNode(sum % 10);
			} else {
				overflow = false;
				p.next = new ListNode(sum);
			}
			p = p.next;
		}

		if (overflow)
			p.next = new ListNode(1);
		return dummy.next;

	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
