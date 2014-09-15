/*
	Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

	For example, Given height = [2,1,5,6,2,3], return 10.	

	Solution: O(n)
    Reference: http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
 
*/

public class Solution {
    public int largestRectangleArea(int[] height) {
        if(height == null || height.length==0){
            return 0;
        }
        
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
        //height[height.length+1]=0;
        
        Stack<Integer> st = new Stack<Integer>();
        int r=0;
        int max=0;
        while(r<h.length){
        	if(st.isEmpty() || h[st.peek()] <= h[r]){
        		st.push(r++);
        	}else{
        		int t = st.pop();
        		int len = st.isEmpty() ? r : r - st.peek() - 1;
        		max = Math.max(max, h[t] * len);
        	}
        }
        
        return max;
    }
}