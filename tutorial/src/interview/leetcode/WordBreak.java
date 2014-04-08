package interview.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	
	/**
	 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

		For example, given
		s = "leetcode",
		dict = ["leet", "code"].
		
		Return true because "leetcode" can be segmented as "leet code".
	 */
	public static void main(String[] args) {
		String s="aaaaaaa";
		Set<String> dict=new HashSet<String>();
		dict.add("aaaa");
		dict.add("aaa");
		WordBreak w=new WordBreak();
		System.out.println(w.wordBreak(s, dict));
	}
	
	//O(n^2) dynamic programming
	public boolean wordBreak(String s, Set<String> dict) {
		ArrayList<Boolean> f = new ArrayList<Boolean>(s.length() + 1);
		for(int i=0; i<s.length() + 1;i++) f.add(false);
		f.set(0, true);
		
		for (int i = 1; i <= s.length(); i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (f.get(j) && dict.contains(s.substring(j, i))) {
					f.set(i, true);
					break;
				}
			}
		}
		return f.get(s.length());
	}
	
	
	//time limit exceed
	//.......... O(2^n)............ O(n)
	public boolean wordBreak2(String s, Set<String> dict) {
        
		String rest=s;
		String match="";
        int i=0;
        boolean segmented=false;
        while(i<rest.length()){
            match+=rest.charAt(i);
            if(dict.contains(match)){
            	if(i+1==rest.length()) 
            		return true;
            	rest=rest.substring(i+1,rest.length());
            	segmented |= wordBreak(rest, dict);
            	
            }
            i++;
            
        }
        return segmented;
    }
	

}
