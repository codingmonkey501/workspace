package interview.leetcode;

import java.util.Arrays;

public class ScrambleString {

	
	/**
	 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

		Below is one possible representation of s1 = "great":
		
		    great
		   /    \
		  gr    eat
		 / \    /  \
		g   r  e   at
		           / \
		          a   t
		To scramble the string, we may choose any non-leaf node and swap its two children.
		
		For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
		
		    rgeat
		   /    \
		  rg    eat
		 / \    /  \
		r   g  e   at
		           / \
		          a   t
		We say that "rgeat" is a scrambled string of "great".
		
		Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
		
		    rgtae
		   /    \
		  rg    tae
		 / \    /  \
		r   g  ta  e
		       / \
		      t   a
		We say that "rgtae" is a scrambled string of "great".
		
		Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
	 */

	// Input: "abcd", "bdac"
	// Output: true
	// Expected: false
	public static void main(String[] args) {
		ScrambleString s=new ScrambleString();
		System.out.println(s.isScramble("rgeat", "great"));
		System.out.println(s.isScramble("rgeata", "great"));
		System.out.println(s.isScramble("abcd", "bdac"));
	}
	
	public boolean isScramble(String s1, String s2) {
		if(s1==null || s2==null || s1.length()!=s2.length()) return false;
        
		//accelerating the caculation
		char[]c1=s1.toCharArray(), c2=s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if(!(new String(c1)).equals(new String(c2))) return false;
        else if(s1.length()==1) return true;
    
        int len=s1.length();
        for(int i=0;i<s1.length()-1;i++){
            if(isScramble(s1.substring(0,i+1), s2.substring(len-i-1)) && isScramble(s1.substring(i+1), s2.substring(0,len-i-1)))
            	return true;
            if(isScramble(s1.substring(0,i+1), s2.substring(0,i+1)) && isScramble(s1.substring(i+1), s2.substring(i+1)))
            	return true;
        }
        return false;
	}
		
	//Time Limit Exceeded
	//Last executed input:	"abcdefghijklmnopq", "efghijklmnopqcadb"
	public boolean isScramble2(String s1, String s2) {
		if(s1==null || s2==null || s1.length()!=s2.length()) return false;
        
		//very slow
		if(s1.length()==1 && s1.equals(s2)) return true;
    
        int len=s1.length();
        for(int i=0;i<s1.length()-1;i++){
            if(isScramble(s1.substring(0,i+1), s2.substring(len-i-1)) && isScramble(s1.substring(i+1), s2.substring(0,len-i-1)))
            	return true;
            if(isScramble(s1.substring(0,i+1), s2.substring(0,i+1)) && isScramble(s1.substring(i+1), s2.substring(i+1)))
            	return true;
        }
        return false;
	}
}
