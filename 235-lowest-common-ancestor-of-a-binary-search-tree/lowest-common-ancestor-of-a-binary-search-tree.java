/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return help(root, p, q);
    }

     public TreeNode help(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        int val = root.val;
        if (p.val < val && q.val < val) return help(root.left, p, q);
        if (p.val > val && q.val > val) return help(root.right, p, q);
        return root;
    }
}