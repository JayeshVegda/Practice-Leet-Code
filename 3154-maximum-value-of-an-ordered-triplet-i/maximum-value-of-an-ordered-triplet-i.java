class Solution {
    public long maximumTripletValue(int[] nums) 
    {
        // finding biggest one
        int left = nums[0];
        long maxi = 0;
        for(int mid = 1; mid < nums.length; mid++)
        {
            if(nums[mid] > left){
                left = nums[mid];
                continue;
            }
            // search 
            for(int right = mid + 1; right < nums.length; right++){
                long cal = (left - nums[mid]) * (long) nums[right];
                maxi = Math.max(maxi, cal);
            }
        }

        return maxi;
    }
}