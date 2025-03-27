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
    public int dfs(TreeNode root){
        if(root == null) return 2;
        int l = dfs(root.left);
        int r = dfs(root.right);
        if(l == 3 || r == 3){
            counter++;
            return 1;
        }

        if(l == 2 && r == 2) {
            return 3;
        }

        return 2;
    }

    public int minCameraCover(TreeNode root) {
        if(dfs(root) == 3) counter++;
        return counter;
    }
}