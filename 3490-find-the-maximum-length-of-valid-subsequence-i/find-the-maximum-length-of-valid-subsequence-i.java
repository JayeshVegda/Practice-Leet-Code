class Solution {
    public int maximumLength(int[] nums) 
    {
        int[] logOne = new int[3];
        int parity = -1;

        for(int i = 0; i < nums.length; i++)
        {
            if(i == 0){
                parity = nums[i] % 2;
                logOne[2]++;
            }
            else{
                int newParity = nums[i] % 2;
                if(newParity != parity)
                {
                    logOne[2]++;
                    parity = newParity;
                }
            }
            
            if(nums[i] % 2 == 0){
                logOne[0]++;
            }else{
                logOne[1]++;
            }
        }

        int res = Math.max(logOne[2], Math.max(logOne[0], logOne[1]));
        return res;
    }
}