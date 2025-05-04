class Graph{
    int n;
    List<List<Integer>> adj;

    Graph(int n){
        this.n = n;
        adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<Integer>());
        }
    }

    public void adder(int src, int dest){
        adj.get(src).add(dest);
        adj.get(dest).add(src);
    }

    public long dfs(int src, boolean[] vis){
        if(vis[src] == true) return 0;

        vis[src] = true;
        long size = 1;

        for(int neg : adj.get(src)){
            // vis[neg] = true;
            size += dfs(neg, vis);
        }

        return size;
    }
}

class Solution {
    public long countPairs(int n, int[][] mat) 
    {
      Graph g = new Graph(n);

      for(int i = 0; i < mat.length; i++){
        int src = mat[i][0];
        int dest = mat[i][1];

        g.adder(src, dest);
      }   

      boolean[] vis = new boolean[n];
      long ans = 0;

      for(int i = 0; i < vis.length; i++){
        if(vis[i] == true) continue;

        long size = g.dfs(i, vis);

        ans += size * (n - size);
      }

      return ans/2;

    }
}