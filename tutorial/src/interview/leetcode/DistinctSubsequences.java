package interview.leetcode;

public class DistinctSubsequences {

	/**
	 * Given a string S and a string T, count the number of distinct
	 * subsequences of T in S.
	 * 
	 * A subsequence of a string is a new string which is formed from the
	 * original string by deleting some (can be none) of the characters without
	 * disturbing the relative positions of the remaining characters. (ie, "ACE"
	 * is a subsequence of "ABCDE" while "AEC" is not).
	 * 
	 * Here is an example: S = "rabbbit", T = "rabbit"
	 * 
	 * Return 3.
	 */
	public static void main(String[] args) {
		DistinctSubsequences d=new DistinctSubsequences();
		d.numDistinct("rabbbit", "rabbit");
	}
	//dynamic programming
	
	// 此题需要使用大数运算。使用一点 DP 即可。关键是如何得到递推关系，可以这样想，设母串的长度为 j，
	// 子串的长度为 i，我们要求的就是长度为 i 的字串在长度为 j 的母串中出现的次数，设为
	// t[i][j]，若母串的最后一个字符与子串的最后一个字符不同，则长度为 i 的子串在长度为 j 的母串中出现的次数就是母串的前 j - 1
	// 个字符中子串出现的次数，即 t[i][j] = t[i][j - 1]，若母串的最后一个字符与子串的最后一个字符相同，那么除了前 j - 1
	// 个字符出现字串的次数外，还要加上子串的前 i - 1 个字符在母串的前 j - 1 个字符中出现的次数，即 t[i][j] = t[i][j -
	// 1] + t[i - 1][j - 1]。
	// 也可以用二维数组，这里图省事，直接用滚动数组了。
	//    r a b b b i t
	//  1 1 1 1 1 1 1 1
	//r 0 1 1 1 1 1 1 1
	//a 0 0 1 1 1 1 1 1
	//b 0 0 0 1 2 3 3 3
	//b 0 0 0 0 1 3 3 3
	//i 0 0 0 0 0 0 3 3
	//t 0 0 0 0 0 0 0 3
	public int numDistinct(String S, String T) {
		int[] f = new int[T.length() + 1];
		f[0] = 1;
		for (int i = 0; i < S.length(); ++i) {
			for (int j = T.length() - 1; j >= 0; --j) {
				f[j + 1] += (S.charAt(i) == T.charAt(j) ? f[j] : 0);
			}
		}
		return f[T.length()];
    }
}
