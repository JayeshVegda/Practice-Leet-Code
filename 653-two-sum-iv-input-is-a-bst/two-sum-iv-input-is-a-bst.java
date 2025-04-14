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
    public boolean findTarget(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                TreeNode rem = q.poll();
                if(rem.left != null) q.add(rem.left);
                if(rem.right != null) q.add(rem.right);

                arr.add(rem.val);
            }
        }

        for(int i = 0; i < arr.size(); i++){
            for(int j = i + 1; j < arr.size(); j++){
                if(arr.get(i) + arr.get(j) == k) return true;
            }
        }

        return false;
    }
}