package interview.leetcode;

public class UniquePaths {

	/**
	 * A robot is located at the top-left corner of a m x n grid (marked 'Start'
	 * in the diagram below).
	 * 
	 * The robot can only move either down or right at any point in time. The
	 * robot is trying to reach the bottom-right corner of the grid (marked
	 * 'Finish' in the diagram below).
	 * 
	 * How many possible unique paths are there?
	 */
	public static void main(String[] args) {
		UniquePaths u=new UniquePaths();
		System.out.println(u.uniquePaths2(23, 10));
		System.out.println(u.uniquePaths(23, 10));
	}

	// Time Limit Exceeded
	public int uniquePaths2(int m, int n) {
		if (m == 0 || n == 0)
			return 0;
		recusive(0, 0, m, n);
		return howmany;
	}

	int howmany = 0;

	public void recusive(int i, int j, int m, int n) {
		if (i == m - 1 && j == n - 1)
			howmany++;
		if (i == m || j == n)
			return;
		recusive(i + 1, j, m, n);
		recusive(i, j + 1, m, n);
	}

	// iterative way
	public int uniquePaths(int m, int n) {
		if (m == 0 || n == 0)
			return 0;
		int[] row = new int[n];
		for (int i = 0; i < n; i++) {
			row[i] = 1;
		}
		for (int r = 1; r < m; r++) {
			for (int c = 1; c < n; c++) {
				// if(c==0) row[0]+=row[0]; //wrong : the first row should alway
				// be 1
				row[c] += row[c - 1];
			}
		}
		return row[row.length - 1];
	}
}
