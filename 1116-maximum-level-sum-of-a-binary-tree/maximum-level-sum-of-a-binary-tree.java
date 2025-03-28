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
    public int maxLevelSum(TreeNode root) {
        int maxi = Integer.MIN_VALUE;
        int res = 0;
        int level = 0;
        
         if(root == null) return 0;
         Queue<TreeNode> q = new LinkedList<>();

         q.add(root);

         while(!q.isEmpty()){
            int size = q.size();
            int max = 0;
            level++;

            while(size-->0){
                TreeNode rem = q.remove();

                if(rem.left != null) q.add(rem.left);
                if(rem.right != null) q.add(rem.right);

                max += rem.val;
            }
           
            if(max > maxi){
                res = level;
                maxi = max;
            }
         }


         return res;
    }
}