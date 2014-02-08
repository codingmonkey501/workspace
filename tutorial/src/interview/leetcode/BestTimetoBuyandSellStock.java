package interview.leetcode;

public class BestTimetoBuyandSellStock {

	
	/**
	 * Say you have an array for which the ith element is the price of a given stock on day i.

		If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
	 */
	public static void main(String[] args) {

	}
	
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0 || prices.length == 1)
			return 0;// forget array size 0

		int max = 0;
		boolean havestock = false;
		int profit = 0;
		int curr = 0;
		int next = 1;
		while (next != prices.length) {
			if (prices[next] > prices[curr]) {
				if (!havestock) {
					profit = 0; // forget to reset profit because
								// "at most one transaction"
					profit -= prices[curr];
					havestock = true;
				}

			} else {
				if (havestock) {
					profit += prices[curr];
					if (profit > max)
						max = profit;
					havestock = false;
				}
			}
			curr++;
			next++;
		}
		if (havestock) {
			profit += prices[curr];
			if (profit > max)
				max = profit;
		}
		return max; //
	}

}
