class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 0;
        int n = nums.length;

        while(right < n){
            int count = 1;
            while(right + 1 < n && nums[right] == nums[right + 1]){
                count++;
                right++;
            }

            int min = Math.min(count, 2);

            for(int i = 0; i < min; i++){
                nums[left] = nums[right];
                left++;
            }

            right++;
        }

        return left;
    }
}