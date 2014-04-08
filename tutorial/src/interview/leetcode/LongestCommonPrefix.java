package interview.leetcode;

public class LongestCommonPrefix {

	/**
	 * Write a function to find the longest common prefix string amongst an
	 * array of strings.
	 */
	public static void main(String[] args) {
		LongestCommonPrefix l=new LongestCommonPrefix();
		System.out.println(l.longestCommonPrefix(new String[]{"a", "b"}));
		System.out.println(l.longestCommonPrefix(new String[]{"a"}));
		System.out.println(l.longestCommonPrefix(new String[]{"aa", "a"}));
	}

	public String longestCommonPrefix(String[] strs) {

		if (strs == null || strs.length == 0 || strs[0].length() == 0)
			return "";

		int c = 0; // for each char
		int s = 0; // for each str
		
		
		while (c < strs[s].length()) {
			char first = strs[s].charAt(c);
			boolean finished=false;
			
			while (s < strs.length) { // wrong here
				if(c == strs[s].length()) {
					finished=true;
					break; //wrong here
				}
				if (first != strs[s].charAt(c)) {
					finished=true; //use finished to jump to the end
					break;
				}
				s++;
			}
			if (finished) break;
			s = 0;
			c++;
		}
		
		
		
		return strs[0].substring(0, c); // wrong here

	}

}
