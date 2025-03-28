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
    public List<Double> averageOfLevels(TreeNode root)
    {
        int level = 0;
        List<Double> res = new ArrayList<>();
         if(root == null) return res;
         Queue<TreeNode> q = new LinkedList<>();

         q.add(root);

         while(!q.isEmpty()){
            int size = q.size();
            double dq = 0;
            int temp = size;

            while(size-->0){
                TreeNode rem = q.remove();

                if(rem.left != null) q.add(rem.left);
                if(rem.right != null) q.add(rem.right);
                
                dq += rem.val;
            }

        
            res.add(dq / temp);
         }


         return res;
    }
}