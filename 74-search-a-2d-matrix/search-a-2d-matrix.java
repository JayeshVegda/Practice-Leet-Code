class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int r = 0;
        int c = m * n - 1;

        while(r <= c)
        {
           int mid = r + (c - r) / 2;

           int nrow = mid / m;
           int ncol = mid % m;
           
           int nval = matrix[nrow][ncol];

           if(nval == target){
            return true;
           }else if(nval > target){
            c = mid - 1;
           }else{
            r = mid + 1;
           }
        }
        return false;
    }
}