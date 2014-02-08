package interview.leetcode;

import java.util.ArrayList;

public class GrayCode {

	/**
	 * The gray code is a binary numeral system where two successive values differ in only one bit.

		Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
		
		For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
		
		00 - 0
		01 - 1
		11 - 3
		10 - 2
		Note:
		For a given n, a gray code sequence is not uniquely defined.
		
		For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
		
		For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
	 */
	public static void main(String[] args) {

	}
	
	
	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int count = 1 << n;
		for (int i = 0; i < count; ++i) {
			result.add(i ^ (i >> 1));
		}
		return result;
	}

	public ArrayList<Integer> grayCode2(int n) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		int num = 1;
		result.add(0);
		if (n == 0)
			return result;
		result.add(1);
		if (n == 1)
			return result;
		int mask = 1;
		boolean moveleft = true;
		int step = 1;
		for (int i = 1; i < (1 << n) - 1; i++) {

			if (moveleft)
				mask = mask << 1; // wrong here i%n-1 will become -1 if i%n==0
			else
				mask = mask >> 1;
			if (step % (n - 1) == 0) {
				step = 0;
				moveleft = !moveleft;
			}
			step++;
			if ((num & mask) == mask)
				num = num & (~mask);
			else
				num = num | mask;
			result.add(num);
		}
		return result;
	}

}
