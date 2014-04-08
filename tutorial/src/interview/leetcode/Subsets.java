package interview.leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class Subsets {

	/**
	 * 
	 Given a set of distinct integers, S, return all possible subsets.
	 * 
	 * Note: Elements in a subset must be in non-descending order. The solution
	 * set must not contain duplicate subsets. For example, If S = [1,2,3], a
	 * solution is:
	 * 
	 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
	 */
	public static void main(String[] args) {
		Subsets s = new Subsets();
		ArrayList<ArrayList<Integer>> result = s.subsets(new int[] {0,1,2});
		for (ArrayList<Integer> arr : result) {
			for (Integer i : arr) {
				System.out.print(i + " , ");
			}
			System.out.print("\n");
		}
	}

	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<Integer> list = new ArrayList<Integer>(S.length);

		for (int i = 0; i < S.length; i++) {
			list.add(S[i]);
		}
		Collections.sort(list);

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		subsets(S, path, 0, result);
		return result;
	}

	public void subsets(int[] S, ArrayList<Integer> path, int step,
			ArrayList<ArrayList<Integer>> result) {
		if (step == S.length) {
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for (Integer num:path) {
				arr.add(num);
				
			}
			Collections.sort(arr);
			result.add(arr);
			return;
		}
		// not choose S[step]
		subsets(S, path, step+1, result);
		// choose S[step]
		path.add(S[step]);
		// System.out.println(S[step]);
		subsets(S, path, step+1, result);
		path.remove(path.size()-1);
	}

}
