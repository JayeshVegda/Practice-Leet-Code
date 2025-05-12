class Solution {
    int dfs(int row, int col, int[][] grid, boolean[][] vis)
    {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return 0;
        if(grid[row][col] == 0 || vis[row][col] == true) return 0;

        int val = 0;
        vis[row][col] = true;
        val += dfs(row + 1, col, grid, vis);
        val += dfs(row - 1, col, grid, vis);
        val += dfs(row, col + 1, grid, vis);
        val += dfs(row, col - 1, grid, vis);

        return val + 1;
    }

    public int maxAreaOfIsland(int[][] grid) 
    {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int max = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int res = dfs(i, j, grid, vis);
                max = Math.max(max, res);
            }
        }
        return max;
    }
}