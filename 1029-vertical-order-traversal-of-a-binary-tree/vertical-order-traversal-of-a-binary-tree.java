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
    List<List<Integer>> res = new ArrayList<>();
    HashMap<Integer, List<Integer>> mpp = new HashMap<>();

    // public void dfs(TreeNode root, int x, int y){
    //     if(root == null) return;

    //     int cordinate = y;
    //     if(mpp.containsKey(cordinate)){
    //         List<Integer> val = mpp.get(cordinate);
    //         val.add(root.val);
    //     }else{
    //         List<Integer> val = new ArrayList<>();
    //         val.add(root.val);
    //         mpp.put(cordinate, val);
    //     }

    //     dfs(root.left, x + 1, y - 1);
    //     dfs(root.right, x + 1, y + 1);
    // }
    // public List<List<Integer>> verticalTraversal(TreeNode root) 
    // {
    //     dfs(root, 0, 0);

    //     int minPos = Integer.MAX_VALUE;
    //     int maxPos = Integer.MIN_VALUE;

    //     for(int key : mpp.keySet()){
    //         minPos = Math.min(minPos, key);
    //         maxPos = Math.max(maxPos, key);
    //     }

    //     System.out.println(minPos);
    //     System.out.println(maxPos);
    //     System.out.println(mpp);

    //     for(int i = minPos; i <= maxPos; i++)
    //     {
    //         if(mpp.containsKey(i)){
    //             List<Integer> values = mpp.get(i);
    //             Collections.sort(values);
    //             res.add(values);
    //         }
    //     }
    //     return res;
    // }

    class Pair implements Comparable<Pair>
    {
        TreeNode node;
        int verLevel;

        Pair(){

        }

        Pair(TreeNode node, int verLevel)
        {
            this.node = node;
            this.verLevel = verLevel;
        }

        @Override
        public int compareTo(Pair other)
        {
            if(this.verLevel != other.verLevel){
                return this.verLevel - other.verLevel; 
            }
            else{
                return this.node.val - other.node.val;
            }
        }
    }

    int minPos = 0;
    int maxPos = 0;

    public void dfs(TreeNode root, int pos){
        if(root == null) return;
        minPos = Math.min(minPos, pos);
        maxPos = Math.max(maxPos, pos);

        dfs(root.left, pos - 1);
        dfs(root.right, pos + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) 
    {
        dfs(root, 0);
        int w = maxPos + Math.abs(minPos) + 1;
        res = new ArrayList<>(w);

        for(int i = 0; i < w; i++){
            res.add(new ArrayList<>());
        }

        Pair myPair = new Pair(root, Math.abs(minPos));
        PriorityQueue<Pair> parent = new PriorityQueue<>();
        parent.add(new Pair(root, Math.abs(minPos)));

        while(!parent.isEmpty()){
            int size = parent.size();
            PriorityQueue<Pair> child = new PriorityQueue<>();

            while(size--> 0)
            {
                Pair rem = parent.poll();
                
                // TreeNode remNode = rem.node
                int idx = rem.verLevel;

                if(rem.node.left != null){
                    Pair nn = new Pair(rem.node.left, rem.verLevel - 1);
                    child.add(nn);
                }

                if(rem.node.right != null){
                    Pair nn = new Pair(rem.node.right, rem.verLevel + 1);
                    child.add(nn);
                }
                res.get(idx).add(rem.node.val);
            }

            parent = child;

        }

        return res;

    }
}