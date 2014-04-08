package interview.leetcode;

public class MinimumWindowSubstring {

	/**
	 * Given a string S and a string T, find the minimum window in S which will
	 * contain all the characters in T in complexity O(n).
	 * 
	 * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
	 * 
	 * Note: If there is no such window in S that covers all characters in T,
	 * return the emtpy string "".
	 * 
	 * If there are multiple such windows, you are guaranteed that there will
	 * always be only one unique minimum window in S.
	 * 
	 */
	public static void main(String[] args) {
		MinimumWindowSubstring m=new MinimumWindowSubstring();
		System.out.println(m.minWindow("abc", "c"));
		System.out.println(m.minWindow("ab", "b"));
		System.out.println(m.minWindow("abcad", "bd"));
		System.out.println(m.minWindow("abcad", "ad"));
		System.out.println(m.minWindow("abcadd", "ad"));
		System.out.println(m.minWindow("abbbaddd", "bd"));
		System.out.println(m.minWindow("aDaaaB", "BD"));
		//System.out.println(m.minWindow("aBaaaDBD", "BD"));
		// System.out.println(m.minWindow("abbbadddbd", "bd")); only one unique
		// window so this case is not really happened
	}
	
	public String minWindow(String S, String T) {
		if (S.isEmpty())
			return "";
		if (S.length() < T.length())
			return "";
		int ASCII_MAX = 256;
		
		int[] appearedCount = new int[ASCII_MAX]; // all 0
		int[] expectedCount = new int[ASCII_MAX]; // all 1
		for (int i = 0; i < T.length(); i++)
			expectedCount[T.charAt(i)]++;
		int minWidth = Integer.MAX_VALUE; // window size
		int minStart = 0;
		int wndStart = 0;
		int appeared = 0; 
		
		
		for (int wndEnd = 0; wndEnd < S.length(); wndEnd++) {
			char ec=S.charAt(wndEnd);
			if (expectedCount[ec] > 0) { // this char is a part of T
				appearedCount[ec]++;
				if (appearedCount[ec]==expectedCount[ec])
					appeared++;
			}
			
			if (appeared == T.length()) {
				// shrink start pointer
				char sc=S.charAt(wndStart);
				while (appearedCount[sc] > expectedCount[sc] || expectedCount[sc] == 0) {
					appearedCount[sc]--;
					sc=S.charAt(++wndStart);
				}
				if (minWidth > (wndEnd - wndStart + 1)) {
					minWidth = wndEnd - wndStart + 1;
					minStart = wndStart;
				}
			}
		}
		
		if (minWidth == Integer.MAX_VALUE)
			return "";
		else
			return S.substring(minStart, minStart + minWidth);
	}

}
