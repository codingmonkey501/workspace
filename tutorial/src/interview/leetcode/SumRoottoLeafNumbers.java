package interview.leetcode;

public class SumRoottoLeafNumbers {

	
	
	/**
	 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

		An example is the root-to-leaf path 1->2->3 which represents the number 123.
		
		Find the total sum of all root-to-leaf numbers.
		
		For example,
		
		    1
		   / \
		  2   3
		The root-to-leaf path 1->2 represents the number 12.
		The root-to-leaf path 1->3 represents the number 13.
		
		Return the sum = 12 + 13 = 25.
	 */
	int total=0;
	public int sumNumbers(TreeNode root) {
		if(root==null) return 0;
		recusive(root, 0);
		return total;
    }
	
	public void recusive(TreeNode node, int sum){
		if(node==null) return;
		
		if(node.left==null && node.right==null) { //need to check if it is a real leaf node
			sum=sum*10+node.val;	// it is not a simple sum, it is 1->2 mean 12
			total+=sum;
			return;
		}
		else{
			sum=sum*10+node.val;
		}
		recusive(node.left, sum);
		recusive(node.right, sum);
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
