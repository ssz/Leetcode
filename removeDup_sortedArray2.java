/*
	Remove Duplicates from Sorted Array II 

	Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?

	For example,
	Given sorted array A = [1,1,1,2,2,3],

	Your function should return length = 5, and A is now [1,1,2,2,3].
*/

public class Solution {
    public int removeDuplicates(int[] A) {
        if(A==null || A.length==0) return 0;
        if(A.length<=2) return A.length;
        int i=2, index=2;
        for(;i<A.length;i++){
            if(A[i]==A[index-1] && A[i]==A[index-2]) continue;
            else A[index++]=A[i];
        }
        return index;
    }
}

// Maintain two pointers to track the index in original array and result array
// And we need a counter to track the occurrence of the value
// time: O(n); space: (1)
public class Solution {
    public int removeDuplicates(int[] A) {
        if (A==null || A.length<=0)
            return 0;
        int i = 1, j = 1, N = A.length, count = 1;
        while (j < N){
           if (A[j]!=A[j-1]){
                A[i++] = A[j++];
                count =1;
           }else{
                if (count < 2)
                    A[i++] = A[j++];
                else  // count>=2, only move forward j
                    j++;
                count++;
           }
        }
        return i;
    }
}



