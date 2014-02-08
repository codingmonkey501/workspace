package interview.leetcode;

public class RemoveDuplicatesfromSortedArray {

	/**
	 * Given a sorted array, remove the duplicates in place such that each
	 * element appear only once and return the new length.
	 * 
	 * Do not allocate extra space for another array, you must do this in place
	 * with constant memory.
	 * 
	 * For example, Given input array A = [1,1,2],
	 * 
	 * Your function should return length = 2, and A is now [1,2].
	 */

	public int removeDuplicates(int[] A) {
		if (A == null)
			return 0;
		int prev = -1;
		int next = 0;
		while (next < A.length) {
			if (prev == -1 || A[next] != A[prev]) {
				prev++;
				if (prev < next)
					A[prev] = A[next];
			}
			next += 1;
		}
		return prev + 1;

		// null
		// 1
		// 1,1
		// 1,1,2
		// 1,1,2,2
	}

	public static void main(String[] args) {

	}

}
