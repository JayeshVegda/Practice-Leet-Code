class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) 
    {
        int len = original.length;
        int counter = 0;
        
        if(n*m == len)
        {
            int newarr[][] = new int[m][n];
            for(int i = 0; i<m; i++){
                for(int j = 0; j<n; j++){
                    newarr[i][j] = original[counter];
                    counter++;
                }
            }
            return newarr;
        }
        else
        {
           int empty[][] = new int[0][0];
           return empty;

        }
    }
}