package interview.leetcode;

public class ReverseInteger {

	public static int reverse1(int x) {
		boolean isNeg = false;
		if (x < 0) {
			isNeg = true;
			x = -x;
		}
		int digitnum = 0;
		int remain = 0;
		int d = 10;
		while (remain != x) {
			if (d < 0) {
				digitnum++;
				break;
			}
			remain = x % d;
			d *= 10;
			digitnum++;
		}

		int[] arr = new int[digitnum];
		d = 10;
		for (int j = 0; j < digitnum; j++) {
			arr[j] = (x % d) / (d / 10); // wrong here
			d *= 10;
		}
		int result = 0;
		for (int j = 0; j < digitnum; j++) {
			int temp = arr[j]; // wrong here
			for (int k = 1; k < digitnum - j; k++) {
				temp *= 10; // wrong here
			}
			if (digitnum - j == 1)
				temp = arr[j]; // wrong here
			if (temp < 0)
				return -1;
			result += temp;
		}
		if (isNeg)
			return -result;
		return result;
	}

	/**
	 * Reverse digits of an integer.
	 * 
	 * Example1: x = 123, return 321 Example2: x = -123, return -321
	 * 
	 * click to show spoilers.
	 * 
	 * Have you thought about this? Here are some good questions to ask before
	 * coding. Bonus points for you if you have already thought through this!
	 * 
	 * If the integer's last digit is 0, what should the output be? ie, cases
	 * such as 10, 100.
	 * 
	 * Did you notice that the reversed integer might overflow? Assume the input
	 * is a 32-bit integer, then the reverse of 1000000003 overflows. How should
	 * you handle such cases?
	 * 
	 * Throw an exception? Good, but what if throwing an exception is not an
	 * option? You would then have to re-design the function (ie, add an extra
	 * parameter).
	 */
	public static int reverse2(int x) {
		
		int reversedNum = 0;
		while (x != 0) {
			int last_digit = x % 10;
			reversedNum = reversedNum * 10 + last_digit;
			x = x / 10;
		}
		//		if (reversedNum > Integer.MAX_VALUE || reversedNum < Integer.MIN_VALUE){
		//	        throw new IllegalArgumentException();
		//	    }
		//there is no check for overflow, but we can check by the changes of sign
		//if sign of reverse got changed then there must be a overflow
		return reversedNum;
	}

	public static void main(String[] args) {
		int result = reverse2(1000000003);
		System.out.println(result);
	}

}
