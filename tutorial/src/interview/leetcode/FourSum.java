package interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class FourSum {

	
	
	/**
	 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

		Note:
		Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
		The solution set must not contain duplicate quadruplets.
		    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
		
		    A solution set is:
		    (-1,  0, 0, 1)
		    (-2, -1, 1, 2)
		    (-2,  0, 0, 2)
	 */
	public static void main(String[] args) {

	}
	
	
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {

	    Arrays.sort(num);
	    
	    HashSet<ArrayList<Integer>> hSet = new HashSet<ArrayList<Integer>>();
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    for (int i = 0; i < num.length; i++) {
	        for (int j = i + 1; j < num.length; j++) {
	            for (int k = j + 1, l = num.length - 1; k < l;) {
	                int sum = num[i] + num[j] + num[k] + num[l];
	                if (sum > target) {
	                    l--;
	                }
	                else if (sum < target) {
	                    k++;
	                }
	                else if (sum == target) {
	                    ArrayList<Integer> found = new ArrayList<Integer>();
	                    found.add(num[i]);
	                    found.add(num[j]);
	                    found.add(num[k]);
	                    found.add(num[l]);
	                    if (!hSet.contains(found)) {
	                        hSet.add(found);
	                        result.add(found);
	                    }

	                    k++;
	                    l--;

	                }
	            }
	        }
	    }
	    return result;
    }

}
