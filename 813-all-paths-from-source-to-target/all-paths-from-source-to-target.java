class Solution {
    List<List<Integer>> paths = new ArrayList<>();
    public void dfs(int src, int dest, ArrayList<Integer> path ,int[][] graph)
    {
        path.add(src);

        if(src == dest){
            paths.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        for(int val : graph[src]){
            dfs(val, dest, path, graph);
        }

        path.remove(path.size() - 1);
        
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        dfs(0, n-1, new ArrayList<Integer>(), graph);
        return paths;
    }
}