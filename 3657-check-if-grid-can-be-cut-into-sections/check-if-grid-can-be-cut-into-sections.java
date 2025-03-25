class Solution {
     public boolean merger(int[][] mat) 
    {
        Arrays.sort(mat, (a1, a2) -> Integer.compare(a1[0], a2[0]));
        int[] curr = mat[0];
        int count = 0;

        for(int i = 1; i < mat.length; i++)
        {
            int start = mat[i][0];

            if(curr[1] > start){
                curr[1] = Math.max(mat[i][1], curr[1]);
            }else{
                count++;
                curr = mat[i];
            }

            if(count == 2) {
                return true;
            }
        }
        return false;
    }

    public boolean checkValidCuts(int n, int[][] mat) {
        int xn = mat.length;

        int[][] x = new int[xn][2];
        int[][] y = new int[xn][2];

        //filling intside
        for(int i = 0; i  < xn; i++){
            int xStart = mat[i][0];
            int yStart = mat[i][1];
            int xEnd = mat[i][2];
            int yEnd = mat[i][3];

            x[i][0] = xStart;
            x[i][1] = xEnd;
            y[i][0] = yStart;
            y[i][1] = yEnd;
        }

        // System.out.println(merger(n,  x));

        boolean resX = merger(x);
        boolean resY = merger(y);

        return resX || resY;

    }
}