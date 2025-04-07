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
    class Pair{
        TreeNode node;
        int idx;

        Pair(){

        }

        Pair(TreeNode node, int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) 
    {
        Deque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root, 0));
        int ans = 0;

        while(!q.isEmpty()){
            int size = q.size();
            int first = q.getFirst().idx;
            int last = q.getLast().idx;
            ans = Math.max(ans, last - first + 1);

            while(size-->0){
                Pair p = q.poll();
                TreeNode node = p.node;
                int idx = (p.idx - first);

                if(node.left != null) q.add(new Pair(node.left, 2*idx+1));
                if(node.right != null) q.add(new Pair(node.right, 2*idx+2));

            }
        }    

        return ans;
    }
}