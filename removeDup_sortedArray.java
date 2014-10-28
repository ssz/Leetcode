/*
	Remove Duplicates from Sorted Array

	Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
	Do not allocate extra space for another array, you must do this in place with constant memory.	

	For example,
	Given input array A = [1,1,2],

	Your function should return length = 2, and A is now [1,2].
*/
// Sorted array means same values

public class Solution {
    public int removeDuplicates(int[] A) {
        if(A==null || A.length==0) return 0;
        int l=A.length, index=1, i=1;
        while(i<l){
            if(A[i]!=A[i-1]) A[index++]=A[i++]; //A[0] doesn't need to record again. So index comes from 1.
            else i++;                           //After index++, it equals to length.
        }
        return index;
    }
}