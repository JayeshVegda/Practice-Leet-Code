class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
      int row = intervals.length;
        Arrays.sort(intervals, Comparator.comparingDouble(o -> o[1]));
        int last = intervals[0][1];
        int counter = 1;
        for(int i = 1; i<row; i++){
            if(intervals[i][0] >= last){
                counter++;
                last = intervals[i][1];
            }
        }
        return row - counter;
    }
}