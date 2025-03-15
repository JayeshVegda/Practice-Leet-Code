class Solution {
    public boolean isValidSudoku(char[][] mat) {
        // inti
        int rows = mat.length;
        int cols = mat[0].length;

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                char ch = mat[row][col];
                if(ch != '.')
                {
                    
                    // check that row
                    for(int i = 0; i < 9; i++){
                        if(i == col) continue;
                        char nch = mat[row][i];
                        if(ch == nch) return false;
                    }
                    

                    // check that col
                    for(int i = 0; i < 9; i++){
                        if(i == row) continue;
                        char nch = mat[i][col];
                        if(ch == nch) return false;
                    }


                    // check that 3*3
                    int nrow = (row / 3) * 3;
                    int ncol = (col / 3) * 3;

                    for(int i = nrow; i < nrow+3; i++){
                        for(int j = ncol; j < ncol+3; j++){
                            if((i != row || j != col) & mat[i][j] == ch) return false;
                        }
                    }   
                }
            }
        }
    
        return true;
    }


}