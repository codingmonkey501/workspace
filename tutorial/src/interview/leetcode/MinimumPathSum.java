package interview.leetcode;

public class MinimumPathSum {

	/**
	 * Given a m x n grid filled with non-negative numbers, find a path from top
	 * left to bottom right which minimizes the sum of all numbers along its
	 * path.
	 * 
	 * Note: You can only move either down or right at any point in time.
	 */
	public static void main(String[] args) {
	}

	int min = 0;

	public int minPathSum(int[][] grid) {

		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;

		for (int n = 0; n < grid[0].length; n++) {
			min += grid[0][n];
		}
		for (int m = 1; m < grid.length; m++) { // should start from 1 : the
												// corner value have been
												// calculate twice
			min += grid[m][grid[0].length - 1];
		}
		recusive(grid, 0, 0, 0);
		return min;
	}

	public void recusive(int[][] grid, int sum, int m, int n) {

		if (m == grid.length - 1 && n == grid[0].length - 1) {// only when the
																// n==length
																// compare the
																// min : don't
																// use
																// m==grid.length&&n==grid[0].length
																// as condition
			sum += grid[m][n];
			if (sum < min)
				min = sum;
			return;
		}
		if (n == grid[0].length || m == grid.length)
			return;
		// because m!=length; it's wrong
		sum += grid[m][n]; // don't put sum + num into parameter otherwise it
							// will caculate wrong
		recusive(grid, sum, m + 1, n);
		recusive(grid, sum, m, n + 1);

	}

}
