class Solution {
    public void dfs(int row, int col, boolean[][] vis, char[][] mat){
        if(row < 0 || row >= vis.length || col < 0 || col >= vis[0].length) return;
        if(mat[row][col] == 'X' || vis[row][col] == true) return;

        vis[row][col] = true;
        dfs(row-1, col, vis, mat);
        dfs(row+1, col, vis, mat);
        dfs(row, col-1, vis, mat);
        dfs(row, col+1, vis, mat);
    }

    public void solve(char[][] mat) 
    {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] vis = new boolean[m][n];
        char[][] res = new char[m][n];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                //checking row;

                if(i == 0 || i == m -1 || j == 0 || j == n - 1)
                {
                    if(mat[i][j] == 'O')
                    {
                        dfs(i, j, vis, mat);
                    }
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++)
            {
                if(mat[i][j] == 'O' && vis[i][j] == false){
                    mat[i][j] = 'X';
                }    
            }
        }

    }
}