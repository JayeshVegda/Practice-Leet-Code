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
    TreeNode prev = new TreeNode();
    int maxi = Integer.MAX_VALUE;
    public void dfs(TreeNode root){
        if(root == null) return;

        dfs(root.left);
        if(prev != null){
            maxi = Math.min(maxi, root.val - prev.val);
        }

        prev = root;
        dfs(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        prev = null;
        dfs(root);
        return maxi;
    }
}