package interview.leetcode;

public class IntegertoRoman {

	/**
	 * Given an integer, convert it to a roman numeral.
	 * 
	 * Input is guaranteed to be within the range from 1 to 3999.
	 */
	public static void main(String[] args) {

	}

	public String intToRoman(int num) {

		String result = "";
		String s = "";
		String n = "";
		String m = "";
		for (int i = 0; i < 4; i++) {
			int digit = num % 10;
			if (i == 0) {
				s = "I";
				n = "V";
				m = "X";
			} else if (i == 1) {
				s = "X";
				n = "L";
				m = "C";
			} else if (i == 2) {
				s = "C";
				n = "D";
				m = "M";
			} else if (i == 3) {
				s = "M";
			}

			switch (digit) {
			case 1:
				result = s + result;
				break;
			case 2:
				result = s + s + result;
				break;
			case 3:
				result = s + s + s + result;
				break;
			case 4:
				result = s + n + result;
				break;
			case 5:
				result = n + result;
				break;
			case 6:
				result = n + s + result;
				break;
			case 7:
				result = n + s + s + result;
				break;
			case 8:
				result = n + s + s + s + result;
				break;
			case 9:
				result = s + m + result;
				break;
			}
			num = num / 10;
		}

		return result;
	}
}
