class Pair{
    int diff;
    int[] cordi;

    Pair(int diff, int[] cordi){
        this.diff = diff;
        this.cordi = cordi;
    }
}

class Solution {
    int[][] dirs = {
        // row - 1 || row + 1 || col - 1 || col + 1 
        {-1, 0}, 
        {1, 0}, 
        {0, -1}, 
        {0, 1}
    };
    public int minimumEffortPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] dest = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dest[i][j] = Integer.MAX_VALUE;
            }
        }

        dest[0][0] = 0;

        PriorityQueue<Pair> q = new PriorityQueue<Pair>((a,b) -> a.diff - b.diff);
        q.add(new Pair(0, new int[]{0, 0}));

        while(!q.isEmpty()){
            Pair rem = q.poll();

            int oldDiff = rem.diff;
            int r = rem.cordi[0];
            int c = rem.cordi[1];
            int oldSteps = mat[r][c];

            if(r == n - 1 && c == m - 1) return oldDiff;
            for(int[] dir : dirs)
            {
                int nr = r +  dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m)
                {
                    // we are inside
                    int newSteps = mat[nr][nc];
                    int newDiff = Math.abs(oldSteps - newSteps); 
                    int maxDiff = Math.max(oldDiff, newDiff);

                    if(maxDiff < dest[nr][nc])
                    {
                        dest[nr][nc] = maxDiff;
                        q.add(new Pair(maxDiff, new int[]{nr, nc} ));
                    }
                }
            }
        }


        System.out.println(Arrays.deepToString(dest));
        return 0;
    }
}