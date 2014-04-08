package interview.leetcode;

public class InterleavingString {

	/**
	 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and
	 * s2.
	 * 
	 * For example, Given: s1 = "aabcc", s2 = "dbbca",
	 * 
	 * When s3 = "aadbbcbcac", return true. When s3 = "aadbbbaccc", return
	 * false.
	 */
	public static void main(String[] args) {
		InterleavingString i=new InterleavingString();
		System.out.println(i.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
	}
	
	
	//timeO(n^2) space O(n^2)
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s3.length() != s1.length() + s2.length())
			return false;
		Boolean[][] f = new Boolean[s1.length() + 1][s2.length() + 1];
		for(int i=0;i<f.length;i++)
			for(int j=0;j<f[0].length;j++)
				f[i][j]=true;
		
		
		for (int i = 1; i <= s1.length(); ++i)
			f[i][0] = f[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
		
		for (int i = 1; i <= s2.length(); ++i)
			f[0][i] = f[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
		
		for (int i = 1; i <= s1.length(); ++i)
			for (int j = 1; j <= s2.length(); ++j)
				f[i][j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && f[i - 1][j])
				|| (s2.charAt(j - 1) == s3.charAt(i + j - 1) && f[i][j - 1]);
		return f[s1.length()][s2.length()];
	}
	
	//timeO(n^2) space O(n)
	public boolean isInterleave2(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length())
			return false;
		if (s1.length() < s2.length())
			return isInterleave(s2, s1, s3);
		Boolean[] f = new Boolean[s2.length() + 1];
		for(int i=0;i<f.length;i++) f[i]=true;
		
		for (int i = 1; i <= s2.length(); ++i)
			f[i] = s2.charAt(i - 1) == s3.charAt(i - 1) && f[i - 1];

		for (int i = 1; i <= s1.length(); ++i) {
			f[0] = s1.charAt(i - 1) == s3.charAt(i - 1) && f[0];

			for (int j = 1; j <= s2.length(); ++j)
				f[j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && f[j])
						|| (s2.charAt(j - 1) == s3.charAt(i + j - 1) && f[j - 1]);
		}
		return f[s2.length()];
	}

}
