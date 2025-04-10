class Graph{
    int n;
    ArrayList<Integer>[] adj;

    Graph(int n){
        this.n = n;
        adj = new ArrayList[n];

         for(int i = 0; i < n; i++)
            adj[i] = new ArrayList<Integer>();
  
    }

   

    public void adder(int src, int des){
        adj[src].add(des);
        adj[des].add(src);
    }

    public boolean dfs(int src, int des, boolean[] vis){
        if(vis[src] == true) return false;
        if(src == des) return true;

        vis[src] = true;
        ArrayList<Integer> dummy = adj[src];
        for(int val : dummy)
        {
            if(dfs(val, des, vis) == true) return true;
        }

        return false;
    }
}

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Graph g = new Graph(n);
        for(int i = 0; i < edges.length; i++){
            int src = edges[i][0];
            int des = edges[i][1];
            g.adder(src, des);
        }

        return g.dfs(source, destination, new boolean[n]);
    }
}