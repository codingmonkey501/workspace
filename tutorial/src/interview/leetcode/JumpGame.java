package interview.leetcode;

public class JumpGame {

	/**
	 * 
	 * Given an array of non-negative integers, you are initially positioned at
	 * the first index of the array.
	 * 
	 * Each element in the array represents your maximum jump length at that
	 * position.
	 * 
	 * Determine if you are able to reach the last index.
	 * 
	 * For example: A = [2,3,1,1,4], return true.
	 * 
	 * A = [3,2,1,0,4], return false.
	 * 
	 */
	public static void main(String[] args) {

		int[] A1 = new int[] { 1, 1, 0 };
		int[] A2 = new int[] { 2, 0, 0 };
		int[] A3 = new int[] { 0, 1, 0 };
		int[] A4 = new int[] { 2, 1, 0 };
		int[] A5 = new int[] { 1, 0 };
		JumpGame j = new JumpGame();
		System.out.println(j.canJump(A1));
		System.out.println(j.canJump(A2));
		System.out.println(j.canJump(A3));
		System.out.println(j.canJump(A4));
		System.out.println(j.canJump(A5));
	}

	public boolean canJump(int[] A) {
		//recusive way but the o complexity is very high
//		if (A == null || A.length == 0)
//			return false;
//		return recusive(A, 0);
		
		
		//iterative way the time complexity is just o(n)
		if (A == null || A.length == 0) return false;
		
		int reach=1;		// the rightmost it can reach
        for (int i=0; i<reach && reach<A.length; i++){
            reach = Math.max(reach, i+A[i]+1);
        }
        return reach>=A.length;
	}
	
    
    public boolean recusive(int[] A, int start) {
		if (start >= A.length - 1)
			return true;
		for (int j = 1; j <= A[start]; j++) {
			if (recusive(A, start + j))
				return true;
			else
				continue;
		}
		return false;
	}

}
