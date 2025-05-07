class Solution 
{   

    public boolean dfs(int node, int[][]g,  boolean[] vis, boolean[] pathVis, boolean[] check)
    {
        vis[node] = true;
        pathVis[node] = true;
        check[node] = false;

        for(int neg : g[node])
        {
            if(!vis[neg])
            {
                if( dfs(neg, g, vis, pathVis, check)) return true;
            }
            else if(pathVis[neg]){
                return true;
            }
        }

        check[node] = true;
        pathVis[node] = false;
        return false;

        } 
    public List<Integer> eventualSafeNodes(int[][] g) 
    {
        int n = g.length;
        boolean[] vis = new boolean[n];
        boolean[] pathVis = new boolean[n];
        boolean[] check = new boolean[n];


        for(int i = 0; i < n; i++){
            if(!vis[i]){
                dfs(i, g, vis, pathVis, check);
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(check[i] == true) res.add(i);
        }

        return res;
    }
}