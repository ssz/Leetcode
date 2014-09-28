/*
    Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

    For example,
    Given n = 3, your program should return all 5 unique BST's shown below.

       1         3     3      2      1
        \       /     /      / \      \
         3     2     1      1   3      2
        /     /       \                 \
       2     1         2                 3
    confused what "{1,#,2,3}" means? (The following can be ignore. This question asked to search adn list all possible BST.)

    OJ's Binary Tree Serialization:
	The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

	Here's an example:
	1
  / \
 2   3
    /			The binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
   4
    \
     5
*/

// Recursion
// Each time, cut the numbers into 3 halves, [start, i-1], i, [i+1, end], which maps to node.left, node, node.right
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return genT(1,n);
    }
    public ArrayList<TreeNode> genT(int start, int end){
        ArrayList<TreeNode> tn= new ArrayList<TreeNode>();
        
        if(start>end){   //Boundary condition of recursive. If there are only two nodes, 
                         //so we need this statement.
            tn.add(null);
        }
        
        if(start==end){
           tn.add(new TreeNode(start));
        }
        
        else if(start<end){
            for(int i=start; i<=end; i++){
                ArrayList<TreeNode> left=genT(start, i-1);
                ArrayList<TreeNode> right=genT(i+1, end);
                for(TreeNode lefts:left){
                    for(TreeNode rights:right){
                        TreeNode temp=new TreeNode(i);
                        temp.left=lefts;
                        temp.right=rights;
                        tn.add(temp);
                    }
                }
            }
       }
       return tn;
    }
}



