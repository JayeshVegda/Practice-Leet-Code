/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution 
{
    boolean isValid = true;

    public void dfs(TreeNode root, long low, long high){
        if(root == null) return;

        // checknig for left 
        
        if(root.val <= low || root.val >= high){
            isValid = false;
            return;
        }

        dfs(root.left, low, root.val);
        dfs(root.right, root.val, high);
    }

    public boolean isValidBST(TreeNode root) 
    {
        if(root.left == null && root.right == null) return true;
        long low = Long.MIN_VALUE;
        long high = Long.MAX_VALUE;
        dfs(root, low, high);
        return isValid;
    }
}