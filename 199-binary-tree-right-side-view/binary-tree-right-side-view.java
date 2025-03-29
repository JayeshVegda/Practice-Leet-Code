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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
    
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> arr = new ArrayList<>();
            while(size-->0)
            {
                TreeNode rem = q.poll();
                
                if(rem.left != null) q.add(rem.left);
                if(rem.right != null) q.add(rem.right);

                arr.add(rem.val);
            }
            res.add(arr.get(arr.size() - 1));
        }

        return res;
    }
}