package interview.leetcode;

public class LongestPalindromicSubstring {

	/**
	 * Given a String S, find the longest palindromic substringing in S. You may
	 * assume that the maximum length of S is 1000, and there exists one unique
	 * longest palindromic substringing.
	 * 
	 */
	public static void main(String[] args) {
		LongestPalindromicSubstring l = new LongestPalindromicSubstring();
		System.out.println(l.longestPalindrome2("CCC"));
		System.out
				.println(l
						.longestPalindrome2("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));

	}

	// Algorithm1: for each char from 0 to n-1 treated as a center, traverse
	// from the center to both sides. The time O(n^2)

	
	// Algorithm2: DP
	public String longestPalindrome2(String s) {
		int n = s.length();
		boolean[][] f = new boolean[n][n]; // all false
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				f[i][j] = false;

		int maxlen = 1, start = 0;
		for (int i = 0; i < n; i++) {
			f[i][i] = true;
			for (int j = 0; j < i; j++) { // [j, i]
				f[j][i] = (s.charAt(j) == s.charAt(i) && (i - j < 2 || f[j + 1][i - 1]));

				int len = i - j + 1;
				if (f[j][i] && maxlen < len) {
					maxlen = len;
					start = j;
				}
			}
		}
		return s.substring(start, start + maxlen);
	}
	
	// Algorithm3: Manacher's Algorithm
	// time O(n) space O(n)
	public String longestPalindrome3(String s) {
		String T = preProcess(s);
		int n = T.length();
		int[] P = new int[n];
		int C = 0, R = 0;
		for (int i = 1; i < n - 1; i++) {
			int i_mirror = 2 * C - i; // equals to i' = C - (i-C)
			P[i] = (R > i) ? Math.min(R - i, P[i_mirror]) : 0;
			// Attempt to expand palindrome centered at i
			while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i]))
				P[i]++;
			// If palindrome centered at i expand past R,
			// adjust center based on expanded palindrome.
			if (i + P[i] > R) {
				C = i;
				R = i + P[i];
			}
		}
		// Find the maximum element in P.
		int maxLen = 0;
		int centerIndex = 0;
		for (int i = 1; i < n - 1; i++) {
			if (P[i] > maxLen) {
				maxLen = P[i];
				centerIndex = i;
			}
		}
		return s.substring((centerIndex - 1 - maxLen) / 2,
				(centerIndex - 1 - maxLen) / 2 + maxLen);
	}

	String preProcess(String s) {
		int n = s.length();
		if (n == 0)
			return "^$";
		String ret = "^";
		for (int i = 0; i < n; i++)
			ret += "#" + s.substring(i, i + 1);
		ret += "#$";
		return ret;
	}

}
