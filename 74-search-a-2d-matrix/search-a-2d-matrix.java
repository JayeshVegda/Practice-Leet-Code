class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int r = 0;
        int c = matrix[0].length - 1;

        while(r<n && c>=0){
            if(matrix[r][c] == target){
                return true;
            }
            else if(target < matrix[r][c]){
                c--;
            }else{
                r++;
            }
        }
        return false;
    }
}