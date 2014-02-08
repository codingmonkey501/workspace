package interview.leetcode;

import java.util.ArrayList;

public class PascalsTriangle {
	
	/**
	 * 
	 * 
	 * Given numRows, generate the first numRows of Pascal's triangle.

		For example, given numRows = 5,
		Return
		
		[
		     [1],
		    [1,1],
		   [1,2,1],
		  [1,3,3,1],
		 [1,4,6,4,1]
		]
	 */
	public static void main(String[] args) {

	}

	public ArrayList<ArrayList<Integer>> generate(int numRows) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (numRows == 0)
			return result; // input 0 expects []
		recusive(numRows, result);
		return result;

	}

	public void recusive(int numRows, ArrayList<ArrayList<Integer>> result) {
		if (numRows == 1) {
			ArrayList<Integer> row = new ArrayList<Integer>();
			row.add(1);
			result.add(row);
			return;
		}
		recusive(numRows - 1, result);
		ArrayList<Integer> row = result.get(numRows - 2); // out of bound
															// because it start
															// from 0
		ArrayList<Integer> newrow = new ArrayList<Integer>();

		newrow.add(1);
		for (int i = 0; i < row.size(); i++) {
			Integer sum = row.get(i);
			if (i + 1 < row.size()) {
				sum += row.get(i + 1);
			}
			newrow.add(sum);
		}
		result.add(newrow);

	}
}
