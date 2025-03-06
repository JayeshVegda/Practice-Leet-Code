class Solution {
    public int[] findMissingAndRepeatedValues(int[][] mat) 
    {
        int n = mat.length;
        int[] frq = new int[n * n + 1];

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                int idx = mat[i][j];
                frq[idx]++; 
            }
        }


        int[] output = new int[2];
        for(int i = 0; i < frq.length; i++)
        {
            if(frq[i] == 0) output[1] = i; 
            if(frq[i] > 1) output[0] = i; 
        }


        return output;
    }
}