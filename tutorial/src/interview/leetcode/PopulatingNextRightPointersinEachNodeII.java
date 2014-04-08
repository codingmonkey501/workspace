package interview.leetcode;


public class PopulatingNextRightPointersinEachNodeII {

	/**
	 * Follow up for problem "Populating Next Right Pointers in Each Node".

		What if the given tree could be any binary tree? Would your previous solution still work?
		
		Note:
		
		You may only use constant extra space.
		For example,
		Given the following binary tree,
		         1
		       /  \
		      2    3
		     / \    \
		    4   5    7
		After calling your function, the tree should look like:
		         1 -> NULL
		       /  \
		      2 -> 3 -> NULL
		     / \    \
		    4-> 5 -> 7 -> NULL
	 */
	public static void main(String[] args) {
		
		TreeLinkNode root= new TreeLinkNode(2);
		TreeLinkNode n11= new TreeLinkNode(1);
		TreeLinkNode n12= new TreeLinkNode(3);
		TreeLinkNode n21= new TreeLinkNode(0);
		TreeLinkNode n22= new TreeLinkNode(7);
		TreeLinkNode n23= new TreeLinkNode(9);
		TreeLinkNode n24= new TreeLinkNode(1);
		root.left=n11;
		root.right=n12;
		n11.left=n21;
		n11.right=n22;
		n12.left=n23;
		n12.right=n24;
		
		
		TreeLinkNode n31= new TreeLinkNode(2);
		TreeLinkNode n33= new TreeLinkNode(1);
		TreeLinkNode n34= new TreeLinkNode(0);
		TreeLinkNode n37= new TreeLinkNode(8);
		TreeLinkNode n38= new TreeLinkNode(8);
		
		n21.left=n31;
		n22.left=n33;
		n22.right=n34;
		n24.left=n37;
		n24.right=n38;
		
		
		TreeLinkNode n45= new TreeLinkNode(7);
		n33.left=n45;
		
		PopulatingNextRightPointersinEachNodeII e=new PopulatingNextRightPointersinEachNodeII();
		e.connect(root);
	}
	
	public void connect2(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode dummy=new TreeLinkNode(-1);
        for (TreeLinkNode curr=root, prev=dummy; curr!=null; curr = curr.next) {
            if (curr.left != null){
                prev.next = curr.left;
                prev = prev.next;
            }
            if (curr.right != null){
                prev.next = curr.right;
                prev = prev.next;
            }
        }
        connect(dummy.next);
   }
   
   
   public void connect(TreeLinkNode root) {
        while (root!=null) {
            TreeLinkNode nextlevel = null; // the first node of next level
            TreeLinkNode prev = null; // previous node on the same level
            while(root!=null){
                if (nextlevel==null) {
                    nextlevel=(root.left!=null ? root.left : root.right);
                }
                if (root.left!=null) {
                    if (prev!=null){
                        prev.next=root.left;
                    }
                    prev=root.left;
                }
                if (root.right!=null) {
                    if (prev!=null) {
                        prev.next=root.right;
                    }
                    prev=root.right;
                }
                root=root.next;
            }
            root=nextlevel; // turn to next level
        }
   }
	
	
	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) {
			val = x;
		}
	}
}
