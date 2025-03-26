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
    List<String> res = new ArrayList<>();
    public void helper(TreeNode root, List<String> dummy,  String asf)
    {
        if(root == null) return;
        if(root.right == null && root.left == null){
            res.add(asf + root.val);
            return;
        }

        helper(root.left, dummy, asf + root.val + "->");
        helper(root.right, dummy, asf + root.val + "->");

    }
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        helper(root, new ArrayList<>(), "");
        return res;
    }
}