package interview.leetcode;

public class ImplementstrStr {

	
	/**
	 * Implement strStr().

		Returns a pointer to the first occurrence of needle in haystack, 
		or null if needle is not part of haystack.
	 */
	public static void main(String[] args) {
		ImplementstrStr i=new ImplementstrStr();
		System.out.println(i.strStr("aaa", "aa"));
		System.out.println(i.strStr("efgabababd", "ababd"));
		System.out.println(i.strStr("babbbbbabb", "bbab"));
		
		System.out.println(i.strStr2("aaa", "aa"));
		System.out.println(i.strStr2("efgabababd", "ababd"));
		System.out.println(i.strStr2("babbbbbabb", "bbab"));
	}
	
	
	//time O(N*M) and space O(1) is good enough for interview
	public String strStr(String haystack, String needle) {
		if(haystack==null || needle==null) 
			return null;
        if(needle.length()==0) 
        	return haystack; // wrong here :"a", "" return "a" 
        					//"","" return ""
        
        boolean nomatch=true;
        
        for(int i=0, j=0, first=0;i<haystack.length();i++){ 
            if(haystack.charAt(i)==needle.charAt(j)){
                if(nomatch){
                    nomatch=false;
                    first=i;
                }
                j++;
                if(j==needle.length()) 
                	return haystack.substring(first); //wrong here : should return first
            }else if(!nomatch){
                i=first; //wrong here : be careful i++ , so do not have to be first + 1
                nomatch=true;
                j=0;
            }
        }
        return null;
    }
	
	
	//KPM time O(n+m) and  space O(M)
	//and others Boyer-Mooer, Rabin-Karp
	public String strStr2(String haystack, String needle) {
		int pos = kmp(haystack, needle);
		if (pos == -1) return null;
		else return haystack.substring(pos);
	}
	
	public void compute_prefix(String pattern, int next[]) {
		int i;
		int j = -1;
		int m = pattern.length();
		next[0] = j;
		for (i = 1; i < m; i++) {
		while (j > -1 && pattern.charAt(j + 1) != pattern.charAt(i)) j = next[j];
		if (pattern.charAt(i) == pattern.charAt(j + 1)) j++;
		next[i] = j;
		}
	}
		
	public int kmp(String text, String pattern) {
		int i;
		int j = -1;
		int n = text.length();
		int m = pattern.length();
		if (n == 0 && m == 0) return 0; /* "","" */
		if (m == 0) return 0; /* "a","" */
		int[] next = new int[m];
		compute_prefix(pattern, next);
		for (i = 0; i < n; i++) {
		while (j > -1 && pattern.charAt(j + 1) != text.charAt(i)) j = next[j];
			if (text.charAt(i) == pattern.charAt(j + 1)) j++;
			if (j == m - 1) {
				return i-j;
			}
		}
		return -1;
	}

}
