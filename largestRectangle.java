/*
	Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

	For example, Given height = [2,1,5,6,2,3], return 10.	

	Solution: O(n)
*/

public class Solution {
    public int largestRectangleArea(int[] height) {
        
        if(height == null || height.length==0){
            return 0;
        }
    
        Stack<Integer> st = new Stack<Integer>();
        Stack<Integer> restack = new Stack<Integer>(); 
        st.push(height[0]);
        int l=1;
        int N = height.length;
        for(int i=1; i<N; i++){
            int oldH=st.pop();
            if(oldH >= height[i]){
                st.push(oldH*l);
                l++;
            }else{
                l=1;
                st.push(height[i]);
            }
        }
        return l*st.pop();
        
    }
}