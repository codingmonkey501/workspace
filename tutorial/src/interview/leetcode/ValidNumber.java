package interview.leetcode;

public class ValidNumber {

	/**
	 * Validate if a given string is numeric.
	 * 
	 * Some examples:
	 * 
	 * "0" => true " 0.1 " => true "abc" => false "1 a" => false "2e10" => true
	 * 
	 * Note: It is intended for the problem statement to be ambiguous. You
	 * should gather all requirements up front before implementing one.
	 * 
	 */
	public static void main(String[] args) {
		ValidNumber v = new ValidNumber();
		System.out.println(v.isNumber("0"));
		System.out.println(v.isNumber("0.1"));
		System.out.println(v.isNumber("abc"));
		System.out.println(v.isNumber("1 a"));
		System.out.println(v.isNumber("1 "));
		System.out.println(v.isNumber(" 1"));
		System.out.println(v.isNumber("2e10"));
		System.out.println(v.isNumber("2e100000000000"));
		System.out.println(v.isNumber("+2 "));
		System.out.println(v.isNumber("+2- "));
		System.out.println(v.isNumber(".2"));
		System.out.println(v.isNumber("+ 2"));
		System.out.println(v.isNumber("+222e222"));
	}

	private enum InputType {
		INVALID, // 0
		SPACE, // 1
		SIGN, // 2
		DIGIT, // 3
		DOT, // 4
		EXPONENT, // 5
		NUM_INPUTS // 6
	}

	private int[][] transitionTable = new int[][] {
			new int[] { -1, 0, 3, 1, 2, -1 }, // next states for state 0
			new int[] { -1, 8, -1, 1, 4, 5 }, // next states for state 1
			new int[] { -1, -1, -1, 4, -1, -1 }, // next states for state 2
			new int[] { -1, -1, -1, 1, 2, -1 }, // next states for state 3
			new int[] { -1, 8, -1, 4, -1, 5 }, // next states for state 4
			new int[] { -1, -1, 6, 7, -1, -1 }, // next states for state 5
			new int[] { -1, -1, -1, 7, -1, -1 }, // next states for state 6
			new int[] { -1, 8, -1, 7, -1, -1 }, // next states for state 7
			new int[] { -1, 8, -1, -1, -1, -1 } // next states for state 8
	};

	public boolean isNumber(String s) {

		int state = 0;
		for (int i = 0; i < s.length(); i++) {
			InputType inputType = InputType.INVALID;
			if (s.charAt(i) == ' ')
				inputType = InputType.SPACE;
			else if (s.charAt(i) == '+' || s.charAt(i) == '-')
				inputType = InputType.SIGN;
			else if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9)
				inputType = InputType.DIGIT;
			else if (s.charAt(i) == '.')
				inputType = InputType.DOT;
			else if (s.charAt(i) == 'e' || s.charAt(i) == 'E')
				inputType = InputType.EXPONENT;
			// Get next state from current state and input symbol
			state = transitionTable[state][inputType.ordinal()];
			// Invalid input
			if (state == -1)
				return false;
		}
		// If the current state belongs to one of the accepting (final) states,
		// then the number is valid
		return state == 1 || state == 4 || state == 7 || state == 8;
	}

}
