class Graph{
    int n;
    boolean res = false;
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

    public void bfs(int src, int dest, boolean[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src] = true;

        while(!q.isEmpty()){
            int rem = q.poll();

            for(int i : adj.get(rem)){
                if(!vis[i]){
                    vis[i] = true;
                    q.add(i);
                }

                if(i == dest){
                    q = new LinkedList<>();
                    res = true;
                    break;
                }
            }
        }
    }
}

class Solution {


    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;
        Graph g = new Graph(n);
        for(int i = 0; i < edges.length; i++){
            int src = edges[i][0];
            int dec = edges[i][1];
            g.adder(src, dec);
        }

        g.bfs(source, destination, new boolean[n]);

        return g.res;
    }
}