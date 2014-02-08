package interview.leetcode;

public class RomantoInteger {

	/**
	 * Given a roman numeral, convert it to an integer.
	 * 
	 * Input is guaranteed to be within the range from 1 to 3999.
	 */
	public static void main(String[] args) {

	}

	public int romanToInt(String s) {
		if (s == null)
			return 0;
		return re(s, ' '); // to prevent from throwing null pointer exception
	}

	public int re(String s, Character last) {
		if (s.isEmpty())
			return 0;
		int num = 0;
		char c = s.charAt(s.length() - 1); // get last character of a string
		switch (c) {
		case 'I':
			if ('V' == last || 'X' == last)
				num = re(s.substring(0, s.length() - 1), c) - 1; // throw null
																	// pointer
																	// exception
			else
				num = re(s.substring(0, s.length() - 1), c) + 1;
			break;
		case 'V':
			num = re(s.substring(0, s.length() - 1), c) + 5;
			break;
		case 'X':
			if ('L' == last || 'C' == last)
				num = re(s.substring(0, s.length() - 1), c) - 10;
			else
				num = re(s.substring(0, s.length() - 1), c) + 10;
			break;
		case 'L':
			num = re(s.substring(0, s.length() - 1), c) + 50;
			break;
		case 'C':
			if ('D' == last || 'M' == last)
				num = re(s.substring(0, s.length() - 1), c) - 100;
			else
				num = re(s.substring(0, s.length() - 1), c) + 100;
			break;
		case 'D':
			num = re(s.substring(0, s.length() - 1), c) + 500;
			break;
		case 'M':
			num = re(s.substring(0, s.length() - 1), c) + 1000;
			break;
		}
		return num;
	}
}
