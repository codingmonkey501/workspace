package interview.leetcode;

public class RotateImage {

	/**
	 * You are given an n x n 2D matrix representing an image.
	 * 
	 * Rotate the image by 90 degrees (clockwise).
	 * 
	 * Follow up: Could you do this in-place?
	 */
	public static void main(String[] args) {
		RotateImage r = new RotateImage();
		int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		r.rotate(matrix);
		System.out.println(r);
	}

	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0
				|| matrix.length == 1)
			return;
		int len = matrix.length;

		int r = 0;
		while (r < len / 2) {
			for (int c = r; c < len - r - 1; c++) { // wrong here the condition
													// should ignore the corner
													// and also consider the
													// inner corner when loop
													// inside
				int temp = matrix[r][c];
				matrix[r][c] = matrix[len - c - 1][r]; // wrong with the 90
														// degree rotate
				matrix[len - c - 1][r] = matrix[len - r - 1][len - c - 1];
				matrix[len - r - 1][len - c - 1] = matrix[c][len - r - 1];
				matrix[c][len - r - 1] = temp;
			}
			r++; // r should be outside for loop
		}
	}
}
