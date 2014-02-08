package interview.leetcode;

public class SingleNumber {

	/**
	 * Given an array of integers, every element appears twice except for one.
	 * Find that single one.
	 * 
	 * Note: Your algorithm should have a linear runtime complexity. Could you
	 * implement it without using extra memory?
	 */
	public static int singleNumber(int[] A) {
		int mask = 0x0001;
		int num =0;
		for (int j=0;j<32;j++){
			int one=0; //wrong here: scope is important when reset
			for(int i=0;i<A.length;i++){
				int bit =A[i] & mask;
				if(bit!=0) one++; //wrong here : check the bit not 0
			}
			if(one%2 != 0)  num = num |(1 << j);
			mask = (mask << 1);
			
		}
		return num;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1,65535,1,2,2,7,65535};
		int num=singleNumber(arr);
		System.out.println(num);
	}
}
