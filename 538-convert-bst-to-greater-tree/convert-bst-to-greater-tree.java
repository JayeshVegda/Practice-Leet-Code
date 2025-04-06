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
class Solution {
     int prev = 0;
    int sum = 0;
    public void dfs(TreeNode root){
        if(root == null) return;

        dfs(root.right);
        
        sum = sum + root.val;
        root.val = sum;
        prev =sum;

        dfs(root.left);
    }
    
    public TreeNode convertBST(TreeNode root) 
    {
        dfs(root);
        return root;
    }


}