package interview.leetcode;

public class UniqueBinarySearchTrees {
	/**
	 * Given n, how many structurally unique BST's (binary search trees) that
	 * store values 1...n?
	 * 
	 * For example, Given n = 3, there are a total of 5 unique BST's.
	 * 
	 * 
	 * 1         3     3      2      1
	    \       /     /      / \      \
	     3     2     1      1   3      2
	    /     /       \                 \
	   2     1         2                 3
	 */
	
	public static int numTrees(int n) {
		
//		int c = 1;
//	    for (int i = 2; i <= n; i++)
//	        c = 2*(2*i-1)*c/(i+1);
//	    return c;
		
//		f(n) = \sum_{i=1}^n f(i-1) * f(n-i), f(0) = 1, f(1) = 1;
//		This is nature for DP (see below).
//		f(n) = (2n)! / (n!*(n+1)!), called Catalan number
		
		
		int[] num = new int[n + 1];
		num[0] = 1;
		
		if (n > 0){
			num[1] = 1;
		}
			
		for (int i = 2; i < n + 1; i++) {
			for (int j = 0; j < i; j++) {
				num[i] += num[j] * num[i - j - 1];
			}
		}
		return num[n];
    }
	
	
	public static void main(String[] args) {
		System.out.println(numTrees(3));
	}

}
