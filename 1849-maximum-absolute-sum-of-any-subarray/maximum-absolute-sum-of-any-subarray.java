class Solution {
    public int maxAbsoluteSum(int[] nums) {

        int max_sum = 0;
        int min_sum = 0;
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            int val = nums[i];
            sum = sum + val;
            max_sum = Math.max(sum, max_sum);
            min_sum = Math.min(sum, min_sum);
        }

        min_sum = Math.abs(min_sum);



        return max_sum + min_sum;
    }
}