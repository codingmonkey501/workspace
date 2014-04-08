package interview.leetcode;

public class RemoveNthNodeFromEndofList {

	
	/**
	 * Given a linked list, remove the nth node from the end of list and return its head.

		For example,
		
		   Given linked list: 1->2->3->4->5, and n = 2.
		
		   After removing the second node from the end, the linked list becomes 1->2->3->5.
		Note:
		Given n will always be valid.
		Try to do this in one pass.
	 */
	public static void main(String[] args) {

	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        int i=recusive(head, n);
        ListNode newHead=head;
        if(i==n+1){
            newHead=head.next;
            head.next=null;
        }
        return newHead;
    }
    
    public int recusive(ListNode node, int n){
        if(node==null) return 1;
        int i=recusive(node.next, n);
        if(i==n+1){
            ListNode ln=node.next;
            node.next=node.next.next;
            ln.next=null;
        }
        return i+1;
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
