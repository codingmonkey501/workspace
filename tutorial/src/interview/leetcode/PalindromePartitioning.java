package interview.leetcode;

import java.util.ArrayList;

public class PalindromePartitioning {

	
	/**
	 * Given a string s, partition s such that every substring of the partition is a palindrome.

		Return all possible palindrome partitioning of s.
		
		For example, given s = "aab",
		Return
		
		  [
		    ["aa","b"],
		    ["a","a","b"]
		  ]
	 */
	public static void main(String[] args) {
		PalindromePartitioning p=new PalindromePartitioning();
		p.partition("a");
		p.partition("abaa");
	}
	
	//there are n-1 place can be disconnected and every place is either connect or disconnected.
	//so the time complexity is O(2^(n-1))
	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<String> path = new ArrayList<String>();
		dfs(s, path, result, 0, 1);
		return result;
	}
	
	
	// s[0, prev-1] has been handled
	// prev is the space between s[prev-1]  s[prev]
	private void dfs(String s, ArrayList<String> path, ArrayList<ArrayList<String>> result, int start, int len) {
		
		if (len == s.length()) { 
			if (isPalindrome(s, start, len-1)) { 
				path.add(s.substring(start, len));
				ArrayList<String> p=new  ArrayList<String>(path);
				result.add(p);
				path.remove(path.size() - 1);
			}
			return;
		}
		
		dfs(s, path, result, start, len + 1);
		
		if (isPalindrome(s, start, len-1)) {
			path.add(s.substring(start, len));
			dfs(s, path, result, len, len + 1);
			path.remove(path.size() - 1);
		}
	}
	
	
	// ex. "aba" "abba"
	private boolean isPalindrome(String s, int a, int b) {
		while (a<=b && s.charAt(a) == s.charAt(b)) {
			++a;
			--b;
		}
		return a >= b;
    }
}
