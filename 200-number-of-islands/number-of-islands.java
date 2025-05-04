class Solution {
    public void dfs(int row, int col, char[][] grid)
    {
        if(row < 0 || col < 0 || col >= grid[0].length || row >= grid.length) return;
        if(grid[row][col] == '0' || grid[row][col]  == '2') return;

        grid[row][col] = '2';
        dfs(row+1, col, grid);
        dfs(row-1, col, grid);
        dfs(row, col+1, grid);
        dfs(row, col-1, grid);
    }
    public int numIslands(char[][] grid) {
        int iLand = 0;

        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == '1')
                {
                    dfs(i, j, grid);
                    iLand++;
                }
            }
        }

        return iLand;

    }
}