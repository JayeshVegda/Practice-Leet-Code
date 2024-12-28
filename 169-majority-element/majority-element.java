class Solution {
    public int majorityElement(int[] nums) {
        int voter = 0;
        int candidate = 0;

        for(int num : nums)
        {
            if(voter == 0){
                candidate = num;
            }

            if(num == candidate){
                voter++;
            }else{
                voter--;
            }
        }

        return candidate;
    }
}