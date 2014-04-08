package interview.leetcode;

public class DivideTwoIntegers {

	/**
	 * Divide two integers without using multiplication, division and mod
	 * operator.
	 */
	public static void main(String[] args) {
		System.out.println("MIN_VALUE=" +Integer.MIN_VALUE + " " + Integer.toBinaryString(Integer.MIN_VALUE));
		System.out.println("VALUE=" +"-1" + "              " + Integer.toBinaryString(-1));
		System.out.println("VALUE=" +"0" + "               " + Integer.toBinaryString(0));
		System.out.println("VALUE=" +"1" + "               " + Integer.toBinaryString(1));
		System.out.println("MAX_VALUE=" +Integer.MAX_VALUE + "   " + Integer.toBinaryString(Integer.MAX_VALUE));
		
		//The unsigned right shift operator ">>>" shifts a zero into the leftmost position
		System.out.println("31 SHIFT VALUE=" +"-1" + "     " + Integer.toBinaryString(-1>>>31));
		//while the leftmost position after ">>" depends on sign extension.
		System.out.println("31 SHIFT VALUE=" +"-1" + "     " + Integer.toBinaryString(-1>>31));
		
		
		System.out.println("---------------------------");
		DivideTwoIntegers d=new DivideTwoIntegers();
		System.out.println(d.divide(8,  3));
		System.out.println(d.divide(Integer.MAX_VALUE,  1));
		System.out.println(d.divide(Integer.MAX_VALUE,  Integer.MIN_VALUE));
	}

	// Note that if the argument is equal to the value of Integer.MIN_VALUE,
	// the most negative representable int value, the result is that same
	// value, which is negative.
	// Integer.MIN_VALUE is -2147483648, but the highest value a 32 bit integer
	// can contain is +2147483647. Attempting to represent +2147483648 in a 32
	// bit int will effectively "roll over" to -2147483648. This is because,
	// when using signed integers, the two's complement binary representations
	// of +2147483648 and -2147483648 are identical. This is not a problem,
	// however, as +2147483648 is considered out of range.

	public int divide(int dividend, int divisor) {

		// int d1 = Math.abs(dividend); //wrong
		// int d2 = Math.abs(divisor);

		// long d1=dividend>=0?dividend:-dividend; //wrong
		// long d2=divisor>=0?divisor:-divisor;

		long a = Math.abs((long) dividend);
		long b = Math.abs((long) divisor);

		int result = 0;
		while (a >= b) {
			long c = b;
			for (int i = 0; a >= c; ++i, c <<= 1) {
				a -= c;
				result += 1 << i;
			}
		}
		
		
		if ((dividend < 0) == (divisor < 0))
			return result;
		else
			return -result;
	}

	// time limit exceed
	public int divide2(int dividend, int divisor) {

		int d1 = Math.abs(dividend);
		int d2 = Math.abs(divisor);
		int i = 0;
		while (d1 >= d2) { // better condition
			d1 -= d2;
			i++;
		}

		// if((dividend<0 && divisor<0) || (dividend>0 && divisor>0))
		// return i;
		// else
		// return -i;

		// if ((dividend ^ divisor) >>> 31 != 0x0) // better
		// return i;
		// else
		// return -i;

		if ((dividend < 0) == (divisor < 0))
			return i;
		else
			return -i;
	}

}
