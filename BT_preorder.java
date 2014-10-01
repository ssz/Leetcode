/* Binary Tree Preorder Traversal */
/* Given a binary tree, return the preorder traversal of its nodes' values.

   For example: Given binary tree {1,#,2,3},   
		1
    	 \
     	  2
    	 /
   		3
	return [1,2,3].
	Note: Recursive solution is trivial, could you do it iteratively?
*/
// Preorder: parent node is processed before its children.
// Thanks to http://blog.csdn.net/xiaozhuaixifu/article/details/14226497

// Solution 1: Iteration
// According to the quetions, use iteration instead of recursion.
// Use Stack from Java Core library

public class Solution {  
    public ArrayList<Integer> preorderTraversal(TreeNode root) {  
       ArrayList<Integer> tree = new ArrayList<Integer>();
       if(root==null) return tree;
       Stack<TreeNode> st = new Stack<TreeNode>();
       st.push(root);
       while(!st.isEmpty()){
           //TreeNode cur=st.peek();
           //tree.add(cur.val);
           //st.pop();
           TreeNode cur=st.pop();
           tree.add(cur.val);
           if(cur.right!=null) st.push(cur.right); // 要先放右元素再放左元素，这样才能在pop时先pop左元素再pop右元素
           if(cur.left!=null) st.push(cur.left);
       }
       return tree;
     }
} 


// Solution 2: Recursion (Can be accepted)
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {  
    public ArrayList<Integer> preorderTraversal(TreeNode root) {  
        ArrayList<Integer> tree = new ArrayList<Integer>();
        if(root==null) return tree;
        return preorder(tree, root);
        //preorder(tree, root);
        //return tree;
     }
     public ArrayList<Integer> preorder(ArrayList<Integer> tree, TreeNode root){
         tree.add(root.val);
         if(root.left!=null) preorder(tree, root.left);
         if(root.right!=null) preorder(tree, root.right);
         return tree;
     }
} 

// Solution 3:
// Threads are references to the predecessor and successor of 
// the node according to an inorder traversal

// Trees whose nodes use threads are called 
// threaded trees

// Morris threaded tree in-order traversal, right plays the role of 'next'
// Great post from AnnieKim. http://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html
// time: O(n); space: O(1)
// Two points to remember:
// [1] If left child is null or predecessor node has been connected, go to right child in next step
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        TreeNode curr = root;
        while (curr!=null){
            if (curr.left==null){
                res.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode prev = curr.left;
                while (prev.right!=null && prev.right!=curr)
                    prev = prev.right;
                if (prev.right==null){
                    prev.right = curr;
                    curr = curr.left;
                }else{
                    prev.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return res;
    }
}

