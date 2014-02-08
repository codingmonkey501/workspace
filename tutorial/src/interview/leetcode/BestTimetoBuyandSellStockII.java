package interview.leetcode;

public class BestTimetoBuyandSellStockII {

	/**
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete as many
	 * transactions as you like (ie, buy one and sell one share of the stock
	 * multiple times). However, you may not engage in multiple transactions at
	 * the same time (ie, you must sell the stock before you buy again).
	 * 
	 */
	public static int maxProfit(int[] prices) {
		boolean haveshare=false;
		int profit=0;
		for(int curr=0;curr<prices.length;curr++){
			int next=curr+1;	
			if(next!=prices.length && prices[next] > prices[curr] ){ //wrong here check bound
				
				if(!haveshare){
					profit-=prices[curr];
					haveshare=true;
				}
			}else{
				
				if(haveshare){
					profit+=prices[curr]; //wrong here
					haveshare=false;
				}
			}
			
		}
		return profit;
    }
	
	public static void main(String[] args) {
		int[] prices=new int[]{2,1,1,2,5,7,7,6,9,1};
		System.out.println(maxProfit(prices));
	}

}
