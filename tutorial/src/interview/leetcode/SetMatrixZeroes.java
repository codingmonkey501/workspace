package interview.leetcode;

public class SetMatrixZeroes {

	/**
	 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

		click to show follow up.
		
		Follow up:
		Did you use extra space?
		A straight forward solution using O(mn) space is probably a bad idea.
		A simple improvement uses O(m + n) space, but still not the best solution.
		Could you devise a constant space solution?
	 */
	public static void main(String[] args) {

	}

	public void setZeroes(int[][] matrix) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return;

		boolean firstrowhaszero = false;
		boolean firstcolhaszero = false;
		for (int c = 0; c < matrix[0].length; c++) {
			if (matrix[0][c] == 0)
				firstrowhaszero = true;
		}
		for (int r = 0; r < matrix.length; r++) {
			if (matrix[r][0] == 0)
				firstcolhaszero = true;
		}

		for (int r = 1; r < matrix.length; r++) { // wrong here :should start
													// from 1
			for (int c = 1; c < matrix[0].length; c++) { // wrong here :should
															// start from 1
				if (matrix[r][c] == 0) {
					matrix[r][0] = 0;
					matrix[0][c] = 0;
				}
			}
		}

		for (int c = 1; c < matrix[0].length; c++) { // wrong here :should start
														// from 1
			if (matrix[0][c] == 0)
				setColZeros(matrix, c);
		}
		for (int r = 0; r < matrix.length; r++) {
			if (matrix[r][0] == 0)
				setRowZeros(matrix, r);
		}
		if (firstrowhaszero)
			setRowZeros(matrix, 0);
		if (firstcolhaszero)
			setColZeros(matrix, 0);

	}

	public void setRowZeros(int[][] matrix, int r) {
		for (int c = 0; c < matrix[0].length; c++) {
			matrix[r][c] = 0;
		}
	}

	public void setColZeros(int[][] matrix, int c) {
		for (int r = 0; r < matrix.length; r++) {
			matrix[r][c] = 0;
		}
	}

}
