package interview.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	/**
	 * Given n pairs of parentheses, write a function to generate all
	 * combinations of well-formed parentheses.
	 * 
	 * For example, given n = 3, a solution set is:
	 * 
	 * "((()))", "(()())", "(())()", "()(())", "()()()"
	 */
	public static void main(String[] args) {
		List<String> arr = generateParenthesis(7);
		for(int i=0;i<arr.size();i++){
			System.out.println(arr.get(i));
		}
	}
	
	
	public static ArrayList<String> generateParenthesis(int n) {
    	ArrayList<String> arr = new ArrayList<String>();
        char[] str = new char[2*n];
        printPar(n, n, str, 0, arr);
        return arr;
    }
    
    public static void printPar(int l, int r, char[] str, int count, ArrayList<String> arr) {
        if (l < 0 || r < l) return; 
        if (l == 0 && r == 0) {
            arr.add(new String(str));
        } else {
            if (l > 0) {
                str[count] = 40;
                printPar(l - 1, r, str, count + 1, arr);
            }
            if (r > l) {
                str[count] = 41;
                printPar(l, r - 1, str, count + 1, arr);
            }
        }
    }
}
