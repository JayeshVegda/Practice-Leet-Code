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
    // public void isSameTree(TreeNode p, TreeNode q) 
    // {
    //     if(p == null &&  q == null) return;

    //     TreeNode temp = p;
    //     p = q;
    //     q = temp;

    // }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        // swap
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        // calling for both
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}