package interview.leetcode;

public class MedianofTwoSortedArrays {

	/**
	 * There are two sorted arrays A and B of size m and n respectively. Find
	 * the median of the two sorted arrays. The overall run time complexity
	 * should be O(log (m+n)).
	 * 
	 */
	public static void main(String[] args) {

		MedianofTwoSortedArrays m = new MedianofTwoSortedArrays();
		System.out.println(m.findMedianSortedArrays(
				new int[] { 1, 3, 8, 9, 10 }, new int[] { 2, 4, 5, 6, 7 }));
	}

	public double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		int total = m + n;

		if (total % 2 != 0) // odd
			return (double) findKth(A, B, total / 2, 0, m - 1, 0, n - 1);
		else { // even
			return (findKth(A, B, total / 2, 0, m - 1, 0, n - 1) + findKth(A,
					B, total / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
		}
	}

	// k is start from 0
	// this is one of the more general questions
	public static int findKth(int A[], int B[], int k, int aStart, int aEnd,
			int bStart, int bEnd) {

		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;

		// Handle special cases
		if (aLen == 0)
			return B[bStart + k];
		if (bLen == 0)
			return A[aStart + k];
		// why min? assume k is 0 and that mean the first element, definitely
		// take the smaller one
		if (k == 0)
			return Math.min(A[aStart], B[bStart]);

		// do not have to care about the relation between index and len, assume
		// there is infinite number of elements in the array
		int aMid = aStart + (k * aLen / (aLen + bLen)); // a's middle count
		int bMid = bStart + (k - aMid - 1); // b's middle count

		if (A[aMid] > B[bMid]) {
			// a's left and b's right
			k = k - (bMid - bStart + 1);
			aEnd = aMid; // why this do not need to minus 1?
			bStart = bMid + 1; // why need plus 1?
		} else {
			// b's left and a's right
			k = k - (aMid - aStart + 1);
			bEnd = bMid;
			aStart = aMid + 1;
		}

		return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
	}
}
