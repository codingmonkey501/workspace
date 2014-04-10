package interview.leetcode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

	/**
	 * Given a string, find the length of the longest substring without
	 * repeating characters. For example, the longest substring without
	 * repeating letters for "abcabcbb" is "abc", which the length is 3. For
	 * "bbbbb" the longest substring is "b", with the length of 1.
	 */
	
	//greedy algorithm:
	// A greedy algorithm is an algorithm that follows the problem solving
	// heuristic of making the locally optimal choice at each stage with the
	// hope of finding a global optimum.
	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> last = new HashMap<Character, Integer>();
		int start = 0;
		for (int i = 0; i < s.length(); i++)
			last.put(s.charAt(i), -1);

		int maxlen = 0;
		for (int i = 0; i < s.length(); i++) {
			if (last.get(s.charAt(i)) >= start) {
				maxlen = Math.max(i - start, maxlen);
				start = last.get(s.charAt(i)) + 1;
			}
			last.put(s.charAt(i), i);
		}
		return Math.max((int) s.length() - start, maxlen);
	}

	// only is alphabatic
	public int lengthOfLongestSubstring2(String s) {
		int ASCII_MAX = 26;
		int[] last = new int[ASCII_MAX];
		int start = 0;
		for (int i = 0; i < last.length; i++)
			last[i] = -1;

		int maxlen = 0;
		for (int i = 0; i < s.length(); i++) {
			if (last[s.charAt(i) - 'a'] >= start) {
				maxlen = Math.max(i - start, maxlen);
				start = last[s.charAt(i) - 'a'] + 1;
			}
			last[s.charAt(i) - 'a'] = i;
		}
		return Math.max((int) s.length() - start, maxlen);
	}
}
