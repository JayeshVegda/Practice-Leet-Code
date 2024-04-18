
public class Solution 
{
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        
        if (matrix == null || matrix.length == 0) {
            return list;
        }
    
        int sr = 0, er = matrix.length - 1;
        int sc = 0, ec = matrix[0].length - 1;
    
        while (sr <= er && sc <= ec) {
            // Print top row
            for (int i = sc; i <= ec; i++) {
                list.add(matrix[sr][i]);
            }
            sr++;
    
            // Print right column
            for (int i = sr; i <= er; i++) {
                list.add(matrix[i][ec]);
            }
            ec--;
    
            // Print bottom row
            if (sr <= er) {
                for (int i = ec; i >= sc; i--) {
                    list.add(matrix[er][i]);
                }
                er--;
            }
    
            // Print left column
            if (sc <= ec) {
                for (int i = er; i >= sr; i--) {
                    list.add(matrix[i][sc]);
                }
                sc++;
            }
        }
        return list;
    }
}