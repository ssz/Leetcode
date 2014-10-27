/*	
	Search Insert Position

	Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order. You may assume no duplicates in the array.

	Here are few examples.
	[1,3,5,6], 5 → 2
	[1,3,5,6], 2 → 1
	[1,3,5,6], 7 → 4
	[1,3,5,6], 0 → 0
*/

public class Solution {
    public int searchInsert(int[] A, int target) {
        if(A==null || A.length==0) return 0;
        int end=A.length-1, start=0;
        while(end>=start){
            int mid=(end+start)/2;
            if(A[mid]==target) return mid;
            if(A[mid]>target) end=mid-1;
            else start=mid+1;
        }
        return end+1;
    }
}