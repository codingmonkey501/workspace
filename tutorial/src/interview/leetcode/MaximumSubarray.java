package interview.leetcode;

public class MaximumSubarray {

	/**
	 * Find the contiguous subarray within an array (containing at least one
	 * number) which has the largest sum.
	 * 
	 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous
	 * subarray [4,−1,2,1] has the largest sum = 6.
	 * 
	 * click to show more practice.
	 * 
	 * More practice: If you have figured out the O(n) solution, try coding
	 * another solution using the divide and conquer approach, which is more
	 * subtle.
	 */

	public int maxSubArray(int[] A) {
		if (A == null)
			return 0;
		int sum = 0;
		int maxsum = A[0];
		int next = 0;
		while (next < A.length) {
			sum += A[next];
			if (A[next] > sum) { // this is a hard part
				sum = A[next];
			}
			if (sum > maxsum)
				maxsum = sum;
			next++;
		}
		return maxsum;
	}

	public static void main(String[] args) {

	}

}
