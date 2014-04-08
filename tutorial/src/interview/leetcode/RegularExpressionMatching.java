package interview.leetcode;

public class RegularExpressionMatching {

	/**
	 * Implement regular expression matching with support for '.' and '*'.
	 * 
	 * '.' Matches any single character. '*' Matches zero or more of the
	 * preceding element.
	 * 
	 * The matching should cover the entire input string (not partial).
	 * 
	 * The function prototype should be: bool isMatch(const char *s, const char
	 * *p)
	 * 
	 * Some examples: isMatch("aa","a") → false isMatch("aa","aa") → true
	 * isMatch("aaa","aa") → false isMatch("aa", "a*") → true isMatch("aa",
	 * ".*") → true isMatch("ab", ".*") → true isMatch("aab", "c*a*b") → true
	 */
	public static void main(String[] args) {
		RegularExpressionMatching r = new RegularExpressionMatching();
		System.out.println(r.isMatch("ba", "a*"));
		System.out.println(r.isMatch("aa", "a*b*"));
		System.out.println(r.isMatch("aaa", "b*a*"));
		System.out.println(r.isMatch("aab", "c*ab*a*b"));
	}


	// recusive way
	public boolean isMatch(String s, String p) {

		if (p.length() == 0)
			return s.length() == 0;

		// p's length 1 is special case
		if (p.length() == 1 || p.charAt(1) != '*') {
			if (s.length() < 1
					|| (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)))
				return false;
			return isMatch(s.substring(1), p.substring(1));

		} else {
			int len = s.length();

			int i = -1; // must be -1 in case "ba" "a*"
			while (i < len
					&& (i == -1 || p.charAt(0) == s.charAt(i) || p.charAt(0) == '.')) {
				if (isMatch(s.substring(i + 1), p.substring(2)))
					return true;
				i++;
			}
			return false;
		}
	}

}
