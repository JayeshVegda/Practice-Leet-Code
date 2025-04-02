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
    public void dfs(TreeNode root, int val)
    {
        if(root == null) {
            return;
        }
        if(root.val <= val){
            if(root.right != null) dfs(root.right, val);
            else {
                TreeNode nn = new TreeNode(val);
                root.right = nn;
                return;
            }
        }

        if(root.val >= val){
            if(root.left != null) dfs(root.left, val);
            else{
                TreeNode nn = new TreeNode(val);
                root.left = nn;
                return;
            }
        }


    }
    public TreeNode insertIntoBST(TreeNode root, int val) 
    {
        if(root == null){
            TreeNode nn = new TreeNode(val);
            return nn;
        }
        dfs(root, val);
        return root;

    }
}