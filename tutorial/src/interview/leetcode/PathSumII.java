package interview.leetcode;

import java.util.ArrayList;

public class PathSumII {

	
	/**
	 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

		For example:
		Given the below binary tree and sum = 22,
		              5
		             / \
		            4   8
		           /   / \
		          11  13  4
		         /  \    / \
		        7    2  5   1
		return
		[
		   [5,4,11,2],
		   [5,8,4,5]
		]
	 */
	public static void main(String[] args) {
	}
	
	
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null) return result;
        ArrayList<Integer> r=new ArrayList<Integer>();
        recusive(root, r, 0, sum);
        return result;
    }
    
    ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
    
    public void recusive(TreeNode node, ArrayList<Integer> r, int sum, int targetsum){
        if(node==null) return;
        ArrayList<Integer> newarr_l=new ArrayList<Integer>(r);
        ArrayList<Integer> newarr_r=new ArrayList<Integer>(r);
        newarr_l.add(node.val);
        newarr_r.add(node.val);
        sum+=node.val;
        if(node.left==null && node.right==null) {
            if(sum==targetsum){
                result.add(newarr_l);
            }
            return;
        }
        recusive(node.left, newarr_l, sum, targetsum);
        recusive(node.right, newarr_r, sum, targetsum);
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