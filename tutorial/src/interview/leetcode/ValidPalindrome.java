package interview.leetcode;

public class ValidPalindrome {

	/**
	 * Given a string, determine if it is a palindrome, considering only
	 * alphanumeric characters and ignoring cases.
	 * 
	 * For example,
		"A man, a plan, a canal: Panama" is a palindrome.
		"race a car" is not a palindrome.
	 * 
	 * Note: Have you consider that the string might be empty? This is a good
	 * question to ask during an interview.
	 * 
	 * For the purpose of this problem, we define empty string as valid
	 * palindrome.
	 */

	public static void main(String[] args) {
		
		ValidPalindrome v=new ValidPalindrome();
		v.isPalindrome("A man, a plan, a canal: Panama");
	}
	public boolean isPalindrome(String s) {
		if(s.isEmpty()) return true;
		s = s.toLowerCase();
		
		int left = 0, right = s.length() - 1;
		while (left < right) {
			if (!isAlphanumeric(s.charAt(left))) //special character should be ignored
				++left;
			else if (!isAlphanumeric(s.charAt(right)))
				--right;
			else if (s.charAt(left++) != s.charAt(right--))
				return false;
		}
		return true;
	}

	private boolean isAlphanumeric(char c) {
		return Character.isAlphabetic(c) || Character.isDigit(c);
	}
}
