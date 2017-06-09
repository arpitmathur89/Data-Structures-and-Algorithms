package array;

public class BuyAndSellStocks {

	public static void main(String[] args) {
		
		int[] prices = {7, 1, 5, 3, 6, 4};
		System.out.println(maxProfit(prices));
		System.out.println(maxProfitI(prices));
		System.out.println(maxProfit2(prices));
	}
	
// Buy and Sell Stocks I

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 * Example 1:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 * 
 */
	// Better Approach then using Kadane's
	public static int maxProfitI(int[] prices) {
		int max = 0;
		int min = prices[0];
		for(int i=0;i<prices.length;i++){
			min =  Math.min(min, prices[i]);
			max = Math.max(max, prices[i]-min);
		}
		return max;	
	}
	
	public static int maxProfit(int[] prices) {
		
		// Kadane's Algorithm Variation
		int curProfit = 0;
		int maxProfit = 0;
		for(int i=1;i<prices.length;i++){
			curProfit = Math.max(prices[i] - prices[i-1], curProfit += prices[i] - prices[i-1]);
			maxProfit = Math.max(curProfit, maxProfit);
		}
		
		return maxProfit;
	}

	
// Buy and Sell Stocks II

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
 * (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions
 * at the same time (ie, you must sell the stock before you buy again).
 * 
 */
	
	 public static int maxProfit2(int[] prices) {
         int max = 0;
         for(int i=1;i<prices.length;i++){
             int price = (prices[i]-prices[i-1])>0?prices[i]-prices[i-1]:0;
             max = max + price;
         }
         return max;
    }
}
