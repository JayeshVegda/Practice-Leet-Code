class Solution {

    public int jump(int[] nums) 
    {   
        int jump = 0;
        int left = 0;
        int right = 0;

        while(right < nums.length - 1 )
        {
            int farest = 0;
            for(int i = left; i <= right; i++){
                farest = Math.max(farest, i + nums[i]);
            }

            left = right + 1;
            right = farest;
            jump++;
           
        }

        return jump;
        
    }
}