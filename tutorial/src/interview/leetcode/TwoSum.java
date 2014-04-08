package interview.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	
	/**
	 * Given an array of integers, find two numbers such that they add up to a specific target number.

		The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
		
		You may assume that each input would have exactly one solution.
		
		Input: numbers={2, 7, 11, 15}, target=9
		Output: index1=1, index2=2
	 */
	public static void main(String[] args) {

	}
	
	//O(n) solution
	public int[] twoSum(int[] numbers, int target) {

		Map<Integer, Integer> mapping = new HashMap<Integer, Integer>();
		int[] result = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			mapping.put(numbers[i], i);
		}
		for (int i = 0; i < numbers.length; i++) {
			mapping.remove(numbers[i]);
			int gap = target - numbers[i];
			if (mapping.containsKey(gap)) {
				result[0] = i + 1;
				result[1] = mapping.get(gap) + 1;
				break;
			}
		}
		return result;
	}

	// time limit exceeded O(n2)
	public int[] twoSum2(int[] numbers, int target) {

		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] + numbers[j] == target) {
					return new int[] { i + 1, j + 1 }; // index none zero based
				}
			}
		}
		return new int[] { 0, 0 };
	}

}
