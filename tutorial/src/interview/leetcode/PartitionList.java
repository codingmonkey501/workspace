package interview.leetcode;

public class PartitionList {

	
	/**
	 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

		You should preserve the original relative order of the nodes in each of the two partitions.
		
		For example,
		Given 1->4->3->2->5->2 and x = 3,
		return 1->2->2->4->3->5.
	 */
	public static void main(String[] args) {

	}
	
	public ListNode partition(ListNode head, int x) {
        ListNode dummyheadleft=new ListNode(Integer.MIN_VALUE);
        ListNode dummyheadright=new ListNode(Integer.MAX_VALUE);
        ListNode p=head;
        ListNode pleft=dummyheadleft;
        ListNode pright=dummyheadright;
        while(p!=null){
            ListNode tmp=p.next;
            p.next=null; //wrong here
            if(p.val<x){//wrong here should not be <=
                pleft.next=p;
                pleft=pleft.next;
            }else{
                pright.next=p;
                pright=pright.next;
            }
            p=tmp;
        }
        if(pleft!=null)//wrong here
            pleft.next=dummyheadright.next;
        else
            dummyheadleft.next=dummyheadright.next;
        return dummyheadleft.next;
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
