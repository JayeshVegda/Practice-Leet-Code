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
    List<List<Integer>> res;
    public void helper(TreeNode root, List<Integer> dummy, int sum, int target)
    {
        if(root == null) return;
        if(root.right == null && root.left == null && sum + root.val == target)
        {
            dummy.add(root.val);
            res.add(new ArrayList<>(dummy));
            dummy.remove(dummy.size() - 1);
            return;
        }
        dummy.add(root.val);
        helper(root.left, dummy, sum + root.val, target );
        dummy.remove(dummy.size() - 1);

        dummy.add(root.val);
        helper(root.right, dummy, sum + root.val, target );
        dummy.remove(dummy.size() - 1);

    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        helper(root, new ArrayList<>(), 0, targetSum);
        return res;
    }
}