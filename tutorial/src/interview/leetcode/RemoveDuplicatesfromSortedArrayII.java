package interview.leetcode;

public class RemoveDuplicatesfromSortedArrayII {

	/**
	 * 
	 * Follow up for "Remove Duplicates": What if duplicates are allowed at most
	 * twice?
	 * 
	 * For example, Given sorted array A = [1,1,1,2,2,3],
	 * 
	 * Your function should return length = 5, and A is now [1,1,2,2,3].
	 * 
	 */
	public static void main(String[] args) {
		RemoveDuplicatesfromSortedArrayII r=new RemoveDuplicatesfromSortedArrayII();
		r.removeDuplicates(new int[]{1,1,1});
	}

	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		int empty = -1;
		int count = 0;
		int curr = A[0];
		for (int i = 0; i < A.length; i++) {
			if (empty != -1) {
				A[empty] = A[i]; // wrong here : no matter curr==A[i] or not, it
									// should replace empty place
				empty++;
			}
			if (A[i] == curr) {
				count++;
				if (count == 3)
					empty = i; // count should be 3
			} else {
				curr = A[i];
				if (count > 2)
					count = 1;
			}
			
		}
		if (empty == -1)
			empty = A.length;
		return empty;
	}
}
