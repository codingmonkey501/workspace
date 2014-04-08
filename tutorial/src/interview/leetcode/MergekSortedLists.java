package interview.leetcode;

import interview.leetcode.AddTwoNumbers.ListNode;

import java.util.ArrayList;

public class MergekSortedLists {

	/**
	 * Merge k sorted linked lists and return it as one sorted list. Analyze and
	 * describe its complexity.
	 */
	public static void main(String[] args) {

	}

	// (1) time O(k*k*M) if triverse one by one and merge
	// (2) a better time O(k*k*m) also if merge first two and merge with the
	// third...
	public ListNode mergeKLists(ArrayList<ListNode> lists) {

		if (lists.size() == 0)
			return null;
		if (lists.size() == 1)
			return lists.get(0);

		ListNode first = lists.get(0);
		for (int i = 1; i < lists.size(); i++) {
			ListNode second = lists.get(i);
			

			if (first == null && second != null) {
				first = second; // in case of [{},{}]
				second = null;
			}
			if (second == null)
				continue;
			
			ListNode head = new ListNode(Integer.MIN_VALUE); //this make code clean
			ListNode p = head;

			while (first != null && second != null) {
				if (first.val > second.val) {
					p.next = second;
					second = second.next;
					p = p.next;
				} else {
					p.next = first;
					first = first.next;
					p = p.next;
				}
			}
			if (first != null)
				p.next = first;
			if (second != null)
				p.next = second;
			first = head.next; //do remember this
		}
		return first;
	}

}
