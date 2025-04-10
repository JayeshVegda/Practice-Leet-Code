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
    public void dfs(TreeNode root, int val){
        if(root == null) return;

        if(root.val < val) {
            if(root.right == null) {
                root.right = new TreeNode(val);
                return;
            }
            dfs(root.right, val);
        }

        if(root.val > val){
            if(root.left == null){
                root.left = new TreeNode(val);
                return;
            }
            dfs(root.left, val);
        }


    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        dfs(root, val);
        return root;
    }
}