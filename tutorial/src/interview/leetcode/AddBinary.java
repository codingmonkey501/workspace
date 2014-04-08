package interview.leetcode;

public class AddBinary {

	
	/**
	 * Given two binary strings, return their sum (also a binary string).

		For example,
		a = "11"
		b = "1"
		Return "100".
	 */
	public static void main(String[] args) {

	}

	public String addBinary(String a, String b) {
		String result = "";
		int n = a.length() > b.length() ? a.length() : b.length();
		a = new StringBuffer(a).reverse().toString();
		b = new StringBuffer(b).reverse().toString();
		int carry = 0;
		for (int i = 0; i < n; i++) {
			int ai = i < a.length() ? a.charAt(i) - '0' : 0;
			int bi = i < b.length() ? b.charAt(i) - '0' : 0;
			int val = (ai + bi + carry) % 2;
			carry = (ai + bi + carry) / 2;
			result += Integer.toString(val);
		}
		if (carry == 1) {
			result += '1';
		}
		return new StringBuffer(result).reverse().toString();
	}

	// too long
	public String addBinary2(String a, String b) {

		String result = "";
		int i = a.length() - 1;
		int j = b.length() - 1;
		boolean overflow = false;
		while (i >= 0 || j >= 0) {
			if (i >= 0 && j >= 0) {
				char c1 = a.charAt(i);
				char c2 = b.charAt(j);
				if (overflow) {
					if (c1 == '1' && c2 == '1') {
						result += '1';
						overflow = true;
					} else if (c1 == '1' || c2 == '1') {
						result += '0';
						overflow = true;
					} else if (c1 == '0' && c2 == '0') {
						result += '1';
						overflow = false;
					}
				} else {
					if (c1 == '1' && c2 == '1') {
						result += '0';
						overflow = true;
					} else if (c1 == '1' || c2 == '1') {
						result += '1';
						overflow = false;
					} else if (c1 == '0' && c2 == '0') {
						result += '0';
						overflow = false;
					}
				}
			} else if (i >= 0 || j >= 0) {
				char c = ' ';
				if (i >= 0)
					c = a.charAt(i);
				else
					c = b.charAt(j);
				if (overflow) {
					if (c == '1') {
						result += '0';
						overflow = true;
					} else {
						result += '1';
						overflow = false;
					}

				} else {
					if (c == '1') {
						result += '1';
						overflow = false;
					} else {
						result += '0';
						overflow = false;
					}
				}
			}
			i--;
			j--;
		}
		if (overflow)
			result += '1';

		return new StringBuilder(result).reverse().toString();
	}

}
