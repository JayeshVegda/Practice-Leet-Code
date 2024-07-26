/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    public boolean isId(TreeNode node, TreeNode subRoot){

        if(node == null && subRoot == null){
            return true;
        }else if(node == null || subRoot == null || subRoot.val != node.val){
            return false;
        }

        if(!isId(node.left, subRoot.left)){
            return false;
        }

        if(!isId(node.right, subRoot.right)){
            return false;
        }

        return true;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null)
        {
            return false;
        }

        if(root.val == subRoot.val)
        {
            if(isId(root, subRoot))
            {
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}