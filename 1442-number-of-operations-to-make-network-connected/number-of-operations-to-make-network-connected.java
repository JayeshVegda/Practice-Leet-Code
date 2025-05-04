class Grahp{    
    int n;
    List<List<Integer>> adj;

    Grahp(int n){
        this.n = n;
        adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<Integer>());
        }
    }

    public void adder(int src, int dest){
        adj.get(src).add(dest);
        adj.get(dest).add(src);
    }

    public void dfs(int src, boolean[] vis){
        if(vis[src] == true) return ;

        vis[src] = true;

        for(int neg : adj.get(src)){
            dfs(neg, vis);
        }
    }
}
class Solution {
    public int makeConnected(int n, int[][] mat) {
        Grahp g = new Grahp(n);
        int reqEdge = n - 1;
        if(reqEdge > mat.length) return -1;

        for(int i = 0; i < mat.length; i++){
            int src = mat[i][0];
            int dest = mat[i][1];

            g.adder(src, dest);
        }

        // finding commponent
        boolean[] b = new boolean[n];
        int comp = 0;

        for(int i = 0; i < b.length; i++)
        {
            if(b[i] == true) continue;
            g.dfs(i, b);
            comp++;
        }


        return comp-1;

    }
}