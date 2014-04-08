package interview.leetcode;

public class SpiralMatrixII {

	
	/**
	 * 
	 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

		For example,
		Given n = 3,
		
		You should return the following matrix:
		[
		 [ 1, 2, 3 ],
		 [ 8, 9, 4 ],
		 [ 7, 6, 5 ]
		]
	 * 
	 */
	public static void main(String[] args) {
		SpiralMatrixII s=new SpiralMatrixII();
		s.generateMatrix(3);
	}

	public int[][] generateMatrix(int n) {

		int[][] result = new int[n][n];
		int r = 0;
		int c = 0;
		//boolean horizontal = true;
		//boolean vertical = false;
		int direction=0; //wrong here: use direction integer to faily control the direction.
		int hrightlimit = n;
		int hleftlimit = -1;
		int vbottomlimit = n;
		int vuplimit = 0;
		for (int i = 0; i < n * n; i++) {

			if (direction==0) {
				result[r][c] = i + 1;
				c++;
				if (c == hrightlimit) {
					direction=1;
					r++;
					c--;
					hrightlimit--;
				}
			} else if (direction==2) {
				result[r][c] = i + 1;
				c--;
				if (c == hleftlimit) {
					direction=3;
					r--;
					c++;
					hleftlimit++;
				}
			} else if (direction==1) {
				result[r][c] = i + 1;
				r++;
				if (r == vbottomlimit) {
					direction=2;
					r--;
					c--;
					vbottomlimit--;
				}
			} else if (direction==3) {
				result[r][c] = i + 1;
				r--;
				if (r == vuplimit) {
					direction=0;
					c++;
					r++;
					vuplimit++;
				}
			}
		}
		return result;
	}
}
