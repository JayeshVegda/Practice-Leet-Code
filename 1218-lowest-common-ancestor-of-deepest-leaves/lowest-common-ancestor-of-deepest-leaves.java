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
    public static class Pair{
        TreeNode root;
        int high;

        Pair(){}
        Pair(TreeNode root, int high){
            this.root = root;
            this.high = high;
        }
    }
    public Pair dfs(TreeNode root)
    {
        if(root == null){
            return new Pair(null, 0);
        }

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        if(left.high == right.high) return new Pair(root, left.high + 1);
        else if(left.high > right.high) return new Pair(left.root, left.high + 1);
        else return new Pair(right.root, right.high + 1);
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair d = dfs(root);
        return d.root;
    }
}