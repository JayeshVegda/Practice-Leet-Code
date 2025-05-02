class Graph{
    int n;
    List<List<Integer>> adj;
    Graph(int n)
    {
        this.n = n;
        adj = new ArrayList<>();
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());
    }

    public void adder(int src, int des){
        adj.get(src).add(des);
        adj.get(des).add(src);
    }

    public boolean dfs(int s, int d, boolean[] vis)
    {
        if(vis[s] == true) return false;
        if(s == d) return true;

        vis[s] = true;
        List<Integer> dummy = adj.get(s);
        for(int i : dummy){
            if(dfs(i, d, vis)) return true;
        }

        return false;
    }
}

class Solution {


    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Graph g = new Graph(n);
        for(int i = 0; i < edges.length; i++){
            int src = edges[i][0];
            int dec = edges[i][1];
            g.adder(src, dec);
        }

        return g.dfs(source, destination, new boolean[n]);
    }
}