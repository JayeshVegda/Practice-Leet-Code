class Solution {
    public int findCircleNum(int[][] mat) 
    {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i <= mat.length; i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < mat.length; i++)
        {
            List<Integer> curr=adj.get(i+1);

            for(int j = 0; j < mat[i].length; j++){
                if(mat[i][j] == 1){
                   curr.add(j+1);
                }
            }
        }

        boolean[] vis = new boolean[mat.length + 1];
        int counter = 0;

        for(int i = 1; i < vis.length; i++){
            if(!vis[i]){
                counter++;
                dfs(i, vis, adj);
            }
        }

        return counter;
    }

    void dfs(int src, boolean[] vis,  List<List<Integer>> adj){
        vis[src] = true;

        for(int neg : adj.get(src)){
            if(!vis[neg]){
                dfs(neg, vis, adj);
            }
        }
    }

}