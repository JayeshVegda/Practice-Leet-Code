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
    public static int hight(TreeNode root){
        if(root == null){
            return 0;
        }

        int l = hight(root.left);
        int r = hight(root.right);

        return Math.max(l, r) + 1;
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

        int ld = diameterOfBinaryTree(root.left);
        int lh = hight(root.left);
        int rd = diameterOfBinaryTree(root.right);
        int rh = hight(root.right);

        int self = lh + rh;

        return Math.max(Math.max(ld, rd), self);


    }
}