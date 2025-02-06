import java.util.ArrayList;

class Solution {
    static List<List<String>> res = new ArrayList<>();

    public static void addways(boolean[][] chess, int n)
    {
        ArrayList<String> strArr = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String str = "";
            for(int j = 0; j < n; j++){
                if(chess[i][j] == true){
                    str += "Q";
                }else{
                    str += ".";
                }
            }
            strArr.add(str);
        }
        
        //adding list into result lists
        res.add(strArr);
    }
    public static boolean isValid(boolean[][] chess, int row, int col, int n)
    {
        // up row--, col
        for(int i = row; i >= 0; i--)
        {
            if(chess[i][col] == true) return false;
        }

        // left side : row --, col--
        for(int rows = row, cols = col; rows >= 0 && cols >= 0; rows--, cols--)
        {
            if(chess[rows][cols] == true) return false;
        }
        // right side : row --, col++
        for(int rows = row, cols = col; rows >= 0 && cols < n; rows--, cols++)
        {
            if(chess[rows][cols] == true) return false;
        }

        return true;
    }
   
    public static void nQueen(boolean[][] chess, int row, int n)
    {
        //base case
        // Base case
        if (row == n) {
            addways(chess, n);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!isValid(chess, row, col, n)) continue;

            chess[row][col] = true;
            nQueen(chess, row + 1, n);
            chess[row][col] = false;
        }
    }
    public  List<List<String>> solveNQueens(int n) 
    {
        res = new ArrayList<>();
        boolean[][] chess = new boolean[n][n];
        nQueen(chess, 0, n);
        return res;
    }
}