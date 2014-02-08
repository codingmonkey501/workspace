package interview.leetcode;

public class RemoveElement {

	/**
	 * Given an array and a value, remove all instances of that value in place
	 * and return the new length.
	 * 
	 * The order of elements can be changed. It doesn't matter what you leave
	 * beyond the new length.
	 */

	public int removeElement(int[] A, int elem) {
		if (A == null)
			return 0;
		int begin = 0;
		int end = A.length - 1;
		int newlength = A.length;
		while (begin <= end) {
			if (A[begin] == elem && A[end] != elem) {
				swap(A, begin, end);
				begin++;
				end--;
				newlength--;
			} else {
				if (A[begin] != elem)
					begin++;
				if (A[end] == elem) {
					end--;
					newlength--;
				}
			}
		}
		return newlength;
	}

	public void swap(int[] A, int begin, int end) {
		int temp = A[begin];
		A[begin] = A[end];
		A[end] = temp;
	}

	public static void main(String[] args) {
		// find 1?
		// 1
		// null
		// 1,1
		// 1,2
		// 1,2,2
		// 2,1,2
		// 2,1,1,2
	}

}
