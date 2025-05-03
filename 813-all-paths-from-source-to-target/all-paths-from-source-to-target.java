class Solution {
    List<List<Integer>> res = new ArrayList<>();

    void dfs(int src, int dest, int[][] g, ArrayList paths)
    {
        paths.add(src);
        if(src == dest){
            res.add(new ArrayList<>(paths));
            paths.remove(paths.size() - 1);
            return;
        }

        for(int val : g[src]){
            dfs(val, dest, g, paths);
        }

        paths.remove(paths.size() - 1);

    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length - 1;
        dfs(0, n, graph, new ArrayList<>());
        return res;
    }
}