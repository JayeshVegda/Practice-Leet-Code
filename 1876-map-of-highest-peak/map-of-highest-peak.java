
class Pair{
    int row;
    int col;
    int dist;
    
    Pair(){}
    Pair(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}


class Solution {
    public int[][] highestPeak(int[][] grid) 
    {
   int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] vis = new boolean[n][m];
        int[][] res = new int[n][m];
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    q.add(new Pair(i, j, 0));
                }
            }
        }
        
        while(!q.isEmpty())
        {
            Pair rem = q.poll();
            
            //Pair Properties
            int remRow = rem.row;
            int remCol = rem.col;
            int remDist = rem.dist;
            
            //Marked Visited
            vis[remRow][remCol] = true;
            res[remRow][remCol] = remDist;
            
            // going up
            if(remRow-1 >= 0 && vis[remRow - 1][remCol] != true && grid[remRow-1][remCol] != 1)
            {
                grid[remRow-1][remCol] = 1;
                q.add(new Pair(remRow-1, remCol, remDist+1));
            }
            // going down
            if(remRow+1 < n && vis[remRow + 1][remCol] != true && grid[remRow+1][remCol] != 1)
            {
                grid[remRow+1][remCol] = 1;
                q.add(new Pair(remRow+1, remCol, remDist+1));
            }
             if(remCol-1 >= 0 && vis[remRow ][remCol- 1] != true && grid[remRow][remCol-1] != 1)
            {
                grid[remRow][remCol-1] = 1;
                q.add(new Pair(remRow, remCol-1, remDist+1));
            }
            // going down
            if(remCol+1 < m && vis[remRow ][remCol+ 1] != true && grid[remRow][remCol + 1] != 1)
            {
                grid[remRow][remCol + 1] = 1;
                q.add(new Pair(remRow, remCol+ 1, remDist+1));
            }
        }
        
        return res;
    }
}