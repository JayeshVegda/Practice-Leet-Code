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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
        {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(right == null){
            return left;
        }

        if(left == null){
            return right;
        }

        return root;
    }
    public int findLevel(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                TreeNode rem = q.poll();
                if(rem.left != null) q.add(rem.left);
                if(rem.right != null) q.add(rem.right);
            }

            level++;
        }   

        return level;
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) 
    {
        int lvl = findLevel(root);
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);

        int level = 1;
        while(!q.isEmpty())
        {
            int size = q.size();
            if(level == lvl) break;
            while(size-->0){
                TreeNode rem = q.poll();
                if(rem.left != null) q.add(rem.left);
                if(rem.right != null) q.add(rem.right);
            }

            level++;
        }   

        TreeNode res = lowestCommonAncestor(root, q.getFirst(), q.getLast());
        return res;
    }
}