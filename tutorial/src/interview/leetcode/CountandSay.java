package interview.leetcode;

public class CountandSay {

	
	
	/**
	 * The count-and-say sequence is the sequence of integers beginning as follows:
		1, 11, 21, 1211, 111221, ...
		
		1 is read off as "one 1" or 11.
		11 is read off as "two 1s" or 21.
		21 is read off as "one 2, then one 1" or 1211.
		Given an integer n, generate the nth sequence.
		
		Note: The sequence of integers will be represented as a string.
	 */
	public static void main(String[] args) {

	}
	
	
	public String countAndSay(int n) {
		String tmpresult = "";
		if (n == 0)
			return tmpresult;
		tmpresult = "";
		String result = "1";
		for (int i = 1; i < n; i++) {
			int count = 1;
			int begin = 0;

			for (int j = 0; j < result.length(); j++) {
				char c1 = result.charAt(j);
				char c2 = ' ';
				if (j + 1 != result.length())
					c2 = result.charAt(j + 1);
				if (c1 == c2) {
					count++;
				} else {
					tmpresult += Integer.toString(count) + result.charAt(begin);
					begin = j + 1;
					count = 1;
				}
			}
			result = tmpresult;
			tmpresult = "";
		}
		return result;
	}

}
