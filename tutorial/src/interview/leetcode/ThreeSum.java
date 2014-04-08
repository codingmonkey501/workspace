package interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSum {

	/**
	 * Given an array S of n integers, are there elements a, b, c in S such that
	 * a + b + c = 0? Find all unique triplets in the array which gives the sum
	 * of zero.
	 * 
	 * Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie,
	 * a ≤ b ≤ c) The solution set must not contain duplicate triplets. For
	 * example, given array S = {-1 0 1 2 -1 -4},
	 * 
	 * A solution set is: (-1, 0, 1) (-1, -1, 2)
	 */
	public static void main(String[] args) {
		ThreeSum t = new ThreeSum();
		System.out.println(t.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
		System.out.println(t.threeSum(new int[] { -2, 0, 0, 2, 2 }));
	}

	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num.length < 3)
			return result;
		Arrays.sort(num);

		int target = 0;
		int len = num.length;
		for (int a = 0; a < len - 2; ++a) {
			int b = a + 1;
			int c = len - 1;
			while (b < c) {
				if (num[a] + num[b] + num[c] < target) {
					++b;
				} else if (num[a] + num[b] + num[c] > target) {
					--c;
				} else {
					ArrayList<Integer> r = new ArrayList<Integer>();
					r.add(num[a]);
					r.add(num[b]);
					r.add(num[c]);
					result.add(r);
					++b;
					--c;
					// good: skip duplicate
					while(c>b && num[b]==num[b-1]) b++;
					while(c>b && num[c]==num[c+1]) c--;
				}
				
			}

			// good: skip duplicate
			while (a + 1 < len && num[a + 1] == num[a]) {
				a++;
			}
		}

		return result;
	}
}
