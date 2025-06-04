class Solution {
    public int majorityElement(int[] nums) 
    {
        int vote = 1;
        int cadident = nums[0];

        for(int i = 1; i < nums.length; i++)
        {
            int val = nums[i];

            if(vote == 0){
                cadident = val;
                vote++;
                continue;
            }

            if(cadident == val){
                vote++;
            }else{
                vote--;
            }
        }

        return cadident;
    }
}