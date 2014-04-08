package interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {

	
	/**
	 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

		The same repeated number may be chosen from C unlimited number of times.
		
		Note:
		All numbers (including target) will be positive integers.
		Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
		The solution set must not contain duplicate combinations.
		For example, given candidate set 2,3,6,7 and target 7, 
		A solution set is: 
		[7] 
		[2, 2, 3] 
	 */
	public static void main(String[] args) {

		CombinationSum c = new CombinationSum();
		c.combinationSum(new int[] { 2, 3, 6, 7 }, 7);

	}

	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		
		Arrays.sort(candidates);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> intermediate = new ArrayList<Integer>();
		dfs(candidates, target, 0, intermediate, result);
		return result;
	}

	private void dfs(int[] candidates, int gap, int start, ArrayList<Integer> intermediate, ArrayList<ArrayList<Integer>> result) {
		
		if (gap == 0) {
			ArrayList<Integer> r=new ArrayList<Integer>(intermediate);
			result.add(r);
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			if (gap < candidates[i])
				return;
			intermediate.add(candidates[i]);
			dfs(candidates, gap - candidates[i], i, intermediate, result);
			intermediate.remove(intermediate.size() - 1);
		}
	}
}
