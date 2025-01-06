class Solution {
    public int maxArea(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int max = Integer.MIN_VALUE;

        while(right > left){
            int left_stick = nums[left];
            int right_stick = nums[right];
            int area = Math.min(left_stick, right_stick) * (right - left);

            max = Math.max(area, max);

            if(left_stick > right_stick){
                right--;
            }else{
                left++;
            }
        }

        return max;
    }
}