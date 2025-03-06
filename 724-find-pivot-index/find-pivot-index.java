class Solution {
    public int pivotIndex(int[] nums) 
    {
        int n = nums.length;
        int totalsum = 0;
        int lsum = 0;


        for(int num : nums){
            totalsum += num;
        }

        for(int i = 0; i < nums.length; i++)
        {
            int right = totalsum - lsum - nums[i];
            if(right == lsum) return i;

            lsum = lsum + nums[i];

            
        }
        return -1;
        
    }
}