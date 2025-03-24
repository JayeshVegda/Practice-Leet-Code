class Solution {
    public int countDays(int days, int[][] mat) 
    {
        int prev = 0;
        Arrays.sort(mat, Comparator.comparingInt(a -> a[0]));

        for(int i = 0; i < mat.length; i++)
        {
            int start = mat[i][0];
            int end = mat[i][1];

            start = Math.max(start, prev + 1);
            int length = end - start + 1;
            days = days - Math.max(length, 0);
            prev = Math.max(prev, end);

        }
        return days;
    }
}