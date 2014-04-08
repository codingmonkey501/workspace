package interview.leetcode;

public class ClimbingStairs {

	/**
	 * You are climbing a stair case. It takes n steps to reach to the top.
	 * 
	 * Each time you can either climb 1 or 2 steps. In how many distinct ways
	 * can you climb to the top?
	 */

	public int climbStairs(int n) { 
		//Fabonacci number
		if (n == 0) return 0;
		int lastonesteps = 0;
		int onesteps = 1;
		int allsteps = 1;
		for (int i = 1; i < n; i++) {
			lastonesteps = onesteps;
			onesteps = allsteps;
			allsteps = onesteps + lastonesteps;
		}
		return allsteps;
	}

	public static void main(String[] args) {
	}

}
