package interview.leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetsII {

	
	/**
	 * Given a collection of integers that might contain duplicates, S, return all possible subsets.

		Note:
		Elements in a subset must be in non-descending order.
		The solution set must not contain duplicate subsets.
		For example,
		If S = [1,2,2], a solution is:
		
		[
		  [2],
		  [1],
		  [1,2,2],
		  [2,2],
		  [1,2],
		  []
		]
	 */
	public static void main(String[] args) {

	}
	
	
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<Integer> list = new ArrayList<Integer>(num.length);

		for (int i = 0; i < num.length; i++) {
			list.add(num[i]);
		}
		Collections.sort(list);

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		subsets(list, path, 0, result);
		return result;
	}

	public void subsets(ArrayList<Integer> S, ArrayList<Integer> path,
			int start, ArrayList<ArrayList<Integer>> result) {

		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (Integer num : path) {
			arr.add(num);
		}
		Collections.sort(arr);
		result.add(arr);

		for (int i = start; i < S.size(); i++) {
			if (i != start && S.get(i) == S.get(i - 1))
				continue;
			path.add(S.get(i));
			subsets(S, path, i + 1, result);
			path.remove(path.size() - 1);
		}

	}

}
