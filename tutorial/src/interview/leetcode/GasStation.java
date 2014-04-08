package interview.leetcode;

public class GasStation {

	
	
	/**
	 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

		You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
		
		Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
		
		Note:
		The solution is guaranteed to be unique.
	 */
	public static void main(String[] args) {

	}
	
	
	public int canCompleteCircuit(int[] gas, int[] cost) {

		int total = 0;
		int j = -1;
		for (int i = 0, sum = 0; i < gas.length; ++i) {
			sum += gas[i] - cost[i];
			total += gas[i] - cost[i];
			if (sum < 0) {
				j = i;
				sum = 0;
			}
		}
		return total >= 0 ? j + 1 : -1;// if total gas is larger than total
										// cost, there must be a gas station
										// that you can start with and around
										// the circuit once.
	}

	// time limit exceed
	public int canCompleteCircuit2(int[] gas, int[] cost) {
		for (int begin = 0; begin < gas.length; begin++) {
			boolean can = canCompleteCircuit(gas, cost, begin, begin, 0);
			if (can)
				return begin;
		}

		return -1;
	}

	public boolean canCompleteCircuit(int[] gas, int[] cost, int pos,
			int origin, int totalgas) {

		// if(pos==origin) return true;
		int curGas = gas[pos] + totalgas;
		int curCost = cost[pos];
		if (curGas >= curCost) {
			totalgas = curGas - curCost;
			pos++;
			if (pos == gas.length)
				pos = 0;
			if (pos == origin)
				return true;
			return canCompleteCircuit(gas, cost, pos, origin, totalgas);
		}
		return false;
	}

}
