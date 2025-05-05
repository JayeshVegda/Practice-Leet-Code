class Pair{
    int row;
    int col;

    Pair(){}
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}

class Solution 
{
    public int numEnclaves(int[][] grid) 
    {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || i == m-1 || j == 0 || j == n-1){
                    if(grid[i][j] == 1){
                        q.add(new Pair(i, j));
                        vis[i][j] = true; 
                    }
                }
            }
        }


        while(!q.isEmpty()){
            Pair rem = q.poll();

            int remRow = rem.row;
            int remCol = rem.col;

            vis[remRow][remCol] = true;

            if(remRow - 1 >= 0 && vis[remRow - 1][remCol] != true && grid[remRow-1][remCol] == 1)
            {
                vis[remRow-1][remCol] = true;
                q.add(new Pair(remRow - 1, remCol));
            }

            if(remRow + 1 < m && vis[remRow + 1][remCol] != true && grid[remRow+1][remCol] == 1)
            {
                vis[remRow+1][remCol] = true;
                q.add(new Pair(remRow + 1, remCol));
            }

            if(remCol + 1 < n && vis[remRow ][remCol+ 1] != true && grid[remRow][remCol+1] == 1)
            {
                vis[remRow][remCol+1] = true;
                q.add(new Pair(remRow, remCol + 1));
            }

            if(remCol - 1 >= 0 && vis[remRow ][remCol-1] != true && grid[remRow][remCol-1] == 1)
            {
                vis[remRow][remCol-1] = true;
                q.add(new Pair(remRow, remCol - 1));
            }
        }

        int counter = 0;

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
               if(grid[i][j] == 1 && vis[i][j] == false)
                   counter++;
            }
        }
        

        return counter;
    }
}