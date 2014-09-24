/*
	Best Time to Buy and Sell Stock II 

	Say you have an array for which the ith element is the price of a given stock on day i.

	Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

*/

/* 
	Solution1: Greedy algorithm
	Remember to sell the stock at end of array.
*/
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length==0)   
            return 0;
        int buy=0; //index of when to buy
        int sell=0; //index of local small, also means when to sell
        int total=0;
        for(int i=0; i<prices.length-1; i++){
            if(prices[i+1]<prices[i]){
                sell=i;
                total+=prices[sell]-prices[buy];
                buy=i+1;
            }
        }
        total+=prices[prices.length-1]-prices[buy];    
        return total;
    }
}


/* Solution 2: Whenever there is difference(and diff>0) between two closed data, add them together.*/
public class Solution {  
    public int maxProfit(int[] prices) {  
        int len = prices.length;  
        if(len == 0) {  
            return 0;  
        }  
          
        int max = 0;  
        for(int i=1; i<len; i++) {  
            int diff = prices[i] - prices[i-1];  
            if(diff > 0) {  
                max += diff;  
            }  
        }  
        return max;  
    }  
}  