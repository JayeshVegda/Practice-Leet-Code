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
    int ans = 0;

    public int dfs(TreeNode root){
        if(root == null) return 0;

        int l = dfs(root.left);
        int r = dfs(root.right);

        ans = ans + Math.abs(l - r);

        return l + r + root.val;
    }
    public int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }
}