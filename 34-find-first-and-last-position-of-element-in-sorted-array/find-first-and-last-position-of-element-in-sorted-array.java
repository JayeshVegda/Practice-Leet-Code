class Solution {
    public int firstOccurance(int[] nums, int x) {
       int ans = -1;
       int left = 0;
       int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == x)
            {
                ans = mid;
                right = mid - 1;
            }else if(nums[mid] < x)
            {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }

    public int SecondOccurance(int[] nums, int x){
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == x)
            {
                ans = mid;
                left = mid + 1;
            }else if(nums[mid] < x){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int first = firstOccurance(nums, target);
        int second = SecondOccurance(nums, target);

        

        return new int[]{first, second};
    }
}