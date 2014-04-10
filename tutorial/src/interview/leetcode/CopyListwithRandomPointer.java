package interview.leetcode;

public class CopyListwithRandomPointer {

	/**
	 * A linked list is given such that each node contains an additional random
	 * pointer which could point to any node in the list or null. Return a deep
	 * copy of the list.
	 */

	public RandomListNode copyRandomList(RandomListNode head) {
		
		//add in between
		for (RandomListNode cur = head; cur != null;) {
			RandomListNode node = new RandomListNode(cur.label);
			node.next = cur.next;
			cur.next = node;
			cur = node.next;
		}

		//copy random
		for (RandomListNode cur = head; cur != null;) {
			if (cur.random != null)
				cur.next.random = cur.random.next;
			cur = cur.next.next;
		}

		//seperate two list
		RandomListNode dummy = new RandomListNode(-1);

		for (RandomListNode cur = head, newcur = dummy; cur != null;) {
			newcur.next = cur.next;
			newcur = newcur.next;
			cur.next = cur.next.next;
			cur = cur.next;
		}
		return dummy.next;
	}
}

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
}