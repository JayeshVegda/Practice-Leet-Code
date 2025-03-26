/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean res = false;
    public void helper(TreeNode root, int sum, int target)
    {
        if(root == null) return;
        if(root.right == null && root.left == null && sum + root.val == target)
        {
            res = true;
            return;
        }

        helper(root.left, sum + root.val, target );
        helper(root.right, sum + root.val, target );

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        helper(root, 0, targetSum);
        return res;
    }
}