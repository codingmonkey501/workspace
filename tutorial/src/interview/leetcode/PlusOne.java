package interview.leetcode;

public class PlusOne {

	
	/**
	 * Given a number represented as an array of digits, plus one to the number.
	 */
	public static void main(String[] args) {

	}
	
	public int[] plusOne(int[] digits) {

		if (digits == null || digits.length == 0)
			return null;
		int i = digits.length - 1;
		boolean overflow = false;
		digits[i] += 1;
		if (digits[i] == 10) {
			overflow = true;
			digits[i] = 0;
		}
		i--;
		while (i > -1) {
			if (overflow) {
				digits[i] += 1;
				overflow = false;
			}
			if (digits[i] == 10) {
				digits[i] = 0;
				overflow = true;
			}
			i--;
		}
		if (overflow) {
			int[] result = new int[digits.length + 1];
			for (int j = digits.length; j > 0; j--) {
				result[j] = digits[j - 1];
			}
			result[0] = 1;
			return result;
		}
		return digits;

	}

}
