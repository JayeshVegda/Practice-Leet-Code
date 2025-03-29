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
    public boolean isCousins(TreeNode root, int x, int y) 
    {
         Queue<TreeNode> q = new LinkedList<>();
         q.add(root);
         int level = 0;

        int xParent = 0;
        int yParent = 1;

         while(!q.isEmpty())
         {
            HashSet<Integer> mpp = new HashSet<>();

            int size = q.size();
            while(size-->0)
            {
                TreeNode rem = q.remove();

                if(rem.left != null) q.add(rem.left);
                if(rem.right != null) q.add(rem.right);


                if(rem.left != null)
                {
                    if(rem.left.val == x) xParent = rem.val;
                    if(rem.left.val == y) yParent = rem.val;
                }

                if(rem.right != null){
                    if(rem.right.val == x) xParent = rem.val;
                    if(rem.right.val == y) yParent = rem.val;
                }

                mpp.add(rem.val);
            }
            if (xParent == yParent) return false;
            if(mpp.contains(x) && mpp.contains(y) && xParent != yParent) return true;
         }



         return false;
    }
}