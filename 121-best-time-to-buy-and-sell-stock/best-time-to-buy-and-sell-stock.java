class Solution {
    public int maxProfit(int[] nums) {
       int max = 0;
       int min = Integer.MAX_VALUE;
       for(int num : nums){
        min = Math.min(min, num);
        max = Math.max(max, num - min);
       }

       return max;
    }
}