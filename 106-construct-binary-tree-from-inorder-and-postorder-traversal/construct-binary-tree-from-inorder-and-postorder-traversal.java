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
    public TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> mpp)
    {
        if(inStart > inEnd || postStart > postEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRootIdx = mpp.get(root.val);

        int calcLeft = inRootIdx - inStart;
        int calcRight = inEnd - inRootIdx;

        root.left = helper(inorder, inStart, inRootIdx - 1, postorder, postStart, postStart + calcLeft - 1, mpp);

        root.right = helper(inorder, inRootIdx + 1, inEnd, 
                                    postorder, postEnd - calcRight, postEnd - 1, mpp);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) 
    {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            mpp.put(inorder[i], i);
        }

        TreeNode root = helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, mpp);

        return root;
    }
}