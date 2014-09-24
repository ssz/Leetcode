/* 
	Best Time to Buy and Sell Stock 
	
	Say you have an array for which the ith element is the price of a given stock on day i.
	If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/

/* 
	Find i and j that maximizes Aj – Ai, where i < j.
	Use min to store the index of current min price. 
	Compare the difference of the current element with the min value to find the max difference.
*/


public class Solution {
    public int maxProfit(int[] prices) {
        
        int min = 0;
        int maxDiff = 0;
        int buy =0; int sell = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[min])
                min = i;
            int diff = prices[i] - prices[min];
            if (diff > maxDiff) {
                buy = min;
                sell = i;
                maxDiff = diff;
            }
        }
        return maxDiff;
    }
}


/* Don't estimate the prices==null or prices.length==0 also accept. */

/* Thanks to http://leetcode.com/2010/11/best-time-to-buy-and-sell-stock.html */