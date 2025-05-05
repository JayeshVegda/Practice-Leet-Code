class Solution {
    public boolean isBipartite(int[][] g) 
    {
        int n = g.length;
        int[] color = new int[n];
        Arrays.fill( color, -1);

        for(int i = 0; i < n; i++){
            if(color[i] == -1){
                if(dfs(i, 1, color, g) == false) return false;
            }
        }

        return true;
    }

    boolean dfs(int node, int col, int[] color, int[][] g){
        color[node] = col;
        for(int i : g[node]){
            if(color[i] == -1){
                if(!dfs(i, 1-col, color, g)){
                    return false;
                }
            }else if(color[i] == col) return false;
        }

        return true;
    }
}