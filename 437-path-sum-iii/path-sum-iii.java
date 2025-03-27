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
    int counter = 0;
    public void helper(TreeNode root, long sum){
        if(root == null) return;

        sum -= (long) root.val;
        if(sum == 0) counter++;

        helper(root.left, sum);
        helper(root.right, sum);

    }

    public void callingAll(TreeNode root, long sum){
        if(root == null) return;

        helper(root, sum);
        callingAll(root.left, sum);
        callingAll(root.right, sum);
    }
    public int pathSum(TreeNode root, int targetSum) {
        callingAll(root, (long) targetSum );
        return counter;
    }
}