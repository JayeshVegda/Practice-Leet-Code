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
    public TreeNode buildTree(int[] pre, int[] in) 
    {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for(int i = 0; i < in.length; i++)
        {
            mpp.put(in[i], i);
        }

        TreeNode root = helper(pre, 0, pre.length -1, in, 0, in.length - 1, mpp);
        return root;
    }
    
    public TreeNode helper(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd, HashMap<Integer, Integer> mpp){
        
        if(preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(pre[preStart]);
        int inRootIdx = mpp.get(root.val);
        int numsLeft = inRootIdx - inStart;

        root.left = helper(pre, preStart + 1, preStart + 1 + numsLeft, 
                                        in, inStart, inRootIdx-1, mpp);

        root.right = helper(pre, preStart + numsLeft + 1, preEnd, 
                                in,  inRootIdx + 1, inEnd, mpp);

        return root;
    }

}