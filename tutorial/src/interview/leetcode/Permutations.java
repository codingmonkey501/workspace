package interview.leetcode;

import java.util.ArrayList;

public class Permutations {

	
	/**
	 * Given a collection of numbers, return all possible permutations.
		
		For example,
		[1,2,3] have the following permutations:
		[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
	 */
	public static void main(String[] args) {

	}
	
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0)
			return result;
		result.add(converfrom(num)); // need to add the first permutation before
										// recusive
		recusive(num, 0, result);
		return result;
	}

	public void recusive(int[] num, int start,
			ArrayList<ArrayList<Integer>> result) {
		if (start == num.length - 1)
			return;
		for (int i = start; i < num.length; i++) {
			swap(num, start, i);
			if (i != start) { // need to check i==start, to prevent 1,2,3 add
								// multiple times
				result.add(converfrom(num)); // how to convert int[] to
												// arrayList
			}
			recusive(num, start + 1, result);
			swap(num, start, i);
		}
	}

	public void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	public ArrayList<Integer> converfrom(int[] num) {
		ArrayList<Integer> list = new ArrayList<Integer>(num.length);
		for (int n : num) {
			list.add(n);
		}
		return list;
	}

}
