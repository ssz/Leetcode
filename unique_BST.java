/* Unique Binary Search Trees */
/*
	Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

	For example, Given n = 3, there are a total of 5 unique BST's.
	 1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

*/

/*
	BST:
	1, the key in any node is larger than the keys in all nodes in that node’s left subtree.
	2, the key in any node is smaller than the keys in all nodes in that node’s right subtree.
	3, the left and right subtree must be BST.
*/

// The result of this combinational problem is called Catalan number.
// http://en.wikipedia.org/wiki/Catalan_number
// Cn = (2n)!/[(n+1)!*n!] = 1/(n+1)*Com(2n, n)
// h(n) = h(1)*h(n-1) + h(2)*h(n-2) + ... + h(n-1)h(1)
// Another combinational example of Catalan number: the number of valid expressions in n pairs of parenthesis

// Number of unique binary trees given n nodes is  N! * Catalan
// Why? Catalan number calcualte the number of binary trees given the array [1...n]
// The array has n! permutaions, each can get Catalan number of binary trees. 
// Cn is the number of full binary trees with n + 1 leaves.


/* Solution 1: recursive */
// Recursion + memoization
// time: O(n^2); space: O(n) + recursive stack
public class Solution {
    
    public int numTrees(int n) {
        int[] mem = new int[n+2];
        Arrays.fill(mem, -1);
        mem[0] = 1;mem[n+1]=1;
        return count(n, mem);
    }
    private int count(int n, int[] mem){
        if (mem[n]!=-1)
            return mem[n];
        int c = 0;
        for (int i=1; i<=n; i++){
            c += count(i-1, mem) * count(n-i, mem);
        }
        mem[n] = c;
        return c;
    }
}


/* Solution 2: Dynamic Programming
   cut array[1,2,...n] into 3 parts, [1...j-1],j,[j+1...n], use left and right half to construct BST
   time: O(n^2); space: O(n)
*/

 public class Solution {
    public int numTrees(int n) {
        if(n<=0) return 0;
        int[] count=new int[n+1];
        count[0]=1; count[1]=1;
        for(int i=2; i<=n; i++){
            for(int j=1; j<=i; j++){
                count[i]+=count[j-1]*count[i-j];
            }
        }
        return count[n];
    }
}


/* Thanks to http://blog.csdn.net/sgbfblog/article/details/7771096 */

