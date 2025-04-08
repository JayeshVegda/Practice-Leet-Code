/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    

    public void dfs(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("1001,");
            return;
        }

        sb.append(root.val + ",");
        dfs(root.left, sb);
        dfs(root.right, sb);

    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) 
    {
        StringBuilder sb = new StringBuilder();
        // String builder
        dfs(root, sb);
        System.out.println(sb.toString());
        return sb.toString();
    }
    public TreeNode buildTree(int[] pre, int[] idx, int end)
    {
        if(idx[0] > end) return null;

        if(pre[idx[0]] == 1001) {
            idx[0]++;
            return null;
        }


        TreeNode root = new TreeNode(pre[idx[0]++]);
        root.left = buildTree(pre, idx, end);
        root.right = buildTree(pre,  idx, end);

        return root;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {
        String[] preOrderString = data.split(",");
        int[] preOrder = new int[preOrderString.length];
        int n = preOrderString.length;

        for(int i = 0; i < n; i++){
            String str = preOrderString[i];
            preOrder[i] = Integer.parseInt(str);
        }
        int[] idx = {0};

        TreeNode root = buildTree(preOrder, idx, preOrder.length-1);
         return root; 
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
