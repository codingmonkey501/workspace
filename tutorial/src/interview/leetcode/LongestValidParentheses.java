package interview.leetcode;

public class LongestValidParentheses {

	
	/**
	 * Given a string containing just the characters '(' and ')', find the
	 * length of the longest valid (well-formed) parentheses substring.
	 * 
	 * For "(()", the longest valid parentheses substring is "()", which has
	 * length = 2.
	 * 
	 * Another example is ")()())", where the longest valid parentheses
	 * substring is "()()", which has length = 4.
	 */
	
	public static void main(String[] args) {
		LongestValidParentheses l=new LongestValidParentheses();
		System.out.println(l.longestValidParentheses(")()())"));
		System.out.println(l.longestValidParentheses(")(()))"));
		System.out.println(l.longestValidParentheses("(()")); //special case
		System.out.println(l.longestValidParentheses("())")); //special case
	}
	public int longestValidParentheses(String s) {
		int maxlen = 0;
		
		for (int i = 0, start = -1, len = 0; i < s.length(); ++i) {
			if (s.charAt(i) == '(') {
				++len;
			} else {
				--len;
				if (len < 0) {
					start = i;
					len = 0;
				} else if (len == 0) {
					maxlen = Math.max(maxlen, i - start);
				}
			}
		}

		for (int i = s.length() - 1, start = s.length(), len = 0; i >= 0; --i) {
			if (s.charAt(i) == ')') {
				++len;
			} else {
				--len;
				if (len < 0) {
					start = i;
					len = 0;
				} else if (len == 0) {
					maxlen = Math.max(maxlen, start - i);
				}
			}
		}
		return maxlen;
	}
}
