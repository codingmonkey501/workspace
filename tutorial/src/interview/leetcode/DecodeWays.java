package interview.leetcode;

public class DecodeWays {

	
	
	/**
	 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

		'A' -> 1
		'B' -> 2
		...
		'Z' -> 26
		Given an encoded message containing digits, determine the total number of ways to decode it.
		
		For example,
		Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
		
		The number of ways decoding "12" is 2.
	 */
	public static void main(String[] args) {
		DecodeWays d =new DecodeWays();
		System.out.println(d.numDecodings("1234422112345"));
	}
	
	
	//something like climbing staires and Fabonacci number
	public int numDecodings(String s) {
		
		if (s.isEmpty() || s.charAt(0) == '0') return 0;
        int prev = 0;
        int cur = 1;
        // string (n length) has n+1 stairs
        for (int i = 1; i <= s.length(); ++i) {
            if (s.charAt(i-1) == '0') 
                cur = 0;
            if (i < 2 || !(s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')))
                prev = 0;
                
            int tmp = cur;
            cur = prev + cur;
            prev = tmp;
        }
        return cur;
    }


	public int numDecodings2(String s) {
		
		if (s.isEmpty() || s.charAt(0) == '0') 
			return 0;
		int prev = 0;
		int cur = 1;
		
		for (int i = 1; i <= s.length(); ++i) {
			if (s.charAt(i-1) == '0') 
				cur = 0;
			if (i < 2 || !(s.charAt(i - 2) == '1' 
					|| (s.charAt(i - 2) == '2' 
					&& s.charAt(i - 1) <= '6')))
			prev = 0;
			int tmp = cur;
			cur = prev + cur;
			prev = tmp;
		}
		return cur;
    }

}
