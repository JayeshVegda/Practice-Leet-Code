class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int[] res = {-1, -1};
        int counter = 0;


        while(start <= end)
        {
            if(nums[start] == target){
                res[0] = start;
                break;
            }

            start++;
        }

        while(start <= end){
            if(nums[end] == target){
                res[1] = end;
                break;
            }

            end--;
        }



        return res;
    }
}