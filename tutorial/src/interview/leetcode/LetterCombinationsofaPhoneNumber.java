package interview.leetcode;

import java.util.ArrayList;

public class LetterCombinationsofaPhoneNumber {

	
	/**
	 * Given a digit string, return all possible letter combinations that the number could represent.

		A mapping of digit to letters (just like on the telephone buttons) is given below.
		
		Input:Digit string "23"
		Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
		Note:
		Although the above answer is in lexicographical order, your answer could be in any order you want.
	 */
	public static void main(String[] args) {

	}
	
	String[] keyboard =new String[]{ " ", "", "abc", "def", // '0','1','2',...
			"ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
	
	public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> result =new ArrayList<String>();
		dfs(digits, 0, "", result);
		return result;
    }
	
	void dfs(String digits, int cur, String path, ArrayList<String> result) {
		if (cur == digits.length()) {
			result.add(path);
			return;
		}
		String str=keyboard[digits.charAt(cur)-'0'];
		for (int i=0; i<str.length();i++) {
			dfs(digits, cur + 1, path + str.charAt(i), result);
		}
	}
}
