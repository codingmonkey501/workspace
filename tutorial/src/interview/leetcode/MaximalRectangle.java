package interview.leetcode;

public class MaximalRectangle {

	/**
	 * Given a 2D binary matrix filled with 0's and 1's, find the largest
	 * rectangle containing all ones and return its area.
	 * 
	 */
	public static void main(String[] args) {

	}

	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int m = matrix.length;
		int n = matrix[0].length;
		int[] H = new int[n]; // all zeros
		int[] L = new int[n]; // all zeros
		int[] R = new int[n]; // all Ns
		for (int i = 0; i < n; i++) {
			H[i] = 0;
			L[i] = 0;
			R[i] = n;
		}

		int area = 0;
		for (int i = 0; i < m; ++i) {
			int left = 0, right = n;
			// calculate L(i, j) from left to right
			for (int j = 0; j < n; ++j) {
				if (matrix[i][j] == '1') {
					++H[j]; // height will increase if there is an one
					L[j] = Math.max(L[j], left); // L[j] stores info for
													// pos j where the left
													// most 1 to make a rect
				} else {
					left = j + 1;
					H[j] = 0; // reset all marker
					L[j] = 0;
					R[j] = n;
				}
			}
			// calculate R(i, j) from right to left
			for (int j = n - 1; j >= 0; --j) {
				if (matrix[i][j] == '1') {
					R[j] = Math.min(R[j], right); // R[j] stores info for pos j
													// the right most 1 to make
													// a rect
					area = Math.max(area, H[j] * (R[j] - L[j]));
				} else {
					right = j;
				}
			}
		}
		return area;
	}

}
