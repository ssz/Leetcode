/* 
	This is not a leetcode question. 
	I saw this question from http://onestraw.net/written-test/find-all-path-whose-value-is-certain-in-binary-tree/
	Blog author: Geeksword
*/

/*
	Question:
	Given a binary tree and a integer, find all routines, sum of the node's value of a routine equals to the integer.
*/

/* Solution: recursive */

void pathSum(BTreeNode *pnode, int *path, int tail, int curSum, int targetSum)
{
    curSum += pnode->cargo;
    path[++tail] = pnode->cargo;
 
    if(curSum == targetSum )
    {
        if(!pnode->left && !pnode->right)
            printPath(path, tail);
    }
    else if(curSum  < targetSum)
    {
        if(pnode->left)
            pathSum(pnode->left, path, tail, curSum, targetSum);
        if(pnode->right)
            pathSum(pnode->right, path, tail, curSum, targetSum);
    }
}