package interview.leetcode;


public class ConvertSortedArraytoBinarySearchTree {
	/**
	 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
	 */
			
	public static void main(String[] args) {

	}
	
	public TreeNode sortedArrayToBST(int[] num) {
        if (num==null) return null;
        return recusive(num, null, 0, num.length); // the area should be [0,len)
    }
    
    public TreeNode recusive(int[] num, TreeNode node, int start, int end){// use start and end to represent the area
        int len=end-start; //to make code clean
        if(len==0) return null;
        if(len>0) {
            node=new TreeNode(num[start+len/2]); //replace with new node
            node.left=recusive(num, node, start, start+len/2);
            node.right=recusive(num, node, start+len/2+1, end);
        }
        return node;
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
