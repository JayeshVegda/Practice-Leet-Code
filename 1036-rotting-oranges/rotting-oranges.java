class Pair{
    int row;
    int col;
    int time;
    Pair(){}
    Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) 
    {   
        int maxTime = 0;
        int freshOranges = 0;


        Queue<Pair> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2) 
                {
                    visited[i][j] = true;
                    q.add(new Pair(i, j, 0));
                }else if(grid[i][j] == 1) freshOranges++;
            }
        }

        if(freshOranges == 0) return 0;



        while(!q.isEmpty())
        {
            Pair rem = q.poll();

            int remRow = rem.row;
            int remCol = rem.col;
            int remTime = rem.time;

            maxTime = Math.max(maxTime, remTime);


            if(remRow - 1 >= 0 && !visited[remRow - 1][remCol] && grid[remRow - 1][remCol] == 1) 
            {
                visited[remRow - 1][remCol] = true;
                q.add(new Pair(remRow - 1, remCol, remTime + 1));
                freshOranges--;
            }

            if(remCol + 1 < n && !visited[remRow][remCol + 1] && grid[remRow][remCol + 1] == 1) {
                visited[remRow][remCol + 1] = true;
                q.add(new Pair(remRow, remCol + 1, remTime + 1));
                freshOranges--;
            }
            
            // Check down
            if(remRow + 1 < m && !visited[remRow + 1][remCol] && grid[remRow + 1][remCol] == 1) {
                visited[remRow + 1][remCol] = true;
                q.add(new Pair(remRow + 1, remCol, remTime + 1));
                freshOranges--;
            }
            
            // Check left
            if(remCol - 1 >= 0 && !visited[remRow][remCol - 1] && grid[remRow][remCol - 1] == 1) {
                visited[remRow][remCol - 1] = true;
                q.add(new Pair(remRow, remCol - 1, remTime + 1));
                freshOranges--;
            }
        }
        
        return freshOranges > 0 ? -1 : maxTime;
    }
}