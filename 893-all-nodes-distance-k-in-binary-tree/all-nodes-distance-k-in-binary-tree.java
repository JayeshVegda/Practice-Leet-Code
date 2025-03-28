/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> path = new ArrayList<>();

    public void dfs(TreeNode root, int k){
        if(root == null) return;

        if(k == 0){
            path.add(root.val);
            return;
        }

        dfs(root.left, k-1);
        dfs(root.right, k-1);
    }

    public int finder(TreeNode root, TreeNode target, int k)
    {
         if(k < 0  || root == null) return - 1;

        if(target == root){
            dfs(root, k);
            return 1; // distance between tar and pair
        }

        int leftDistance = finder(root.left, target, k);
        if(leftDistance > 0) {
            if(leftDistance == k) path.add(root.val);
            else dfs(root.right, k -leftDistance  - 1);
            return leftDistance + 1;
        }

        int rightDistance = finder(root.right, target, k);
        if(rightDistance > 0) {
            if(rightDistance == k) path.add(root.val);
            else dfs(root.left, k - rightDistance - 1);
            return rightDistance + 1;
        }

        return -1;

    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) 
    {
        finder(root, target, k);
        return path;
    }
}
