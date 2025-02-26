class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max = 0;
        int min = 0;
        int max_sum = 0;
        int min_sum = 0;

        for(int i = 0; i < nums.length; i++){
            int val = nums[i];
            int nmaxsum = max_sum + val;
            int nminsum = min_sum + val;

            //min count
            if(nminsum >= 0){
                min_sum = 0;
            }else{
                min_sum = nminsum;
            }


            // max count
            if(nmaxsum <= 0){
                max_sum = 0;
            }else{
                max_sum = nmaxsum;
            }

            max = Math.max(nmaxsum, max);
            min = Math.min(nminsum, min);
        }

        min = Math.abs(min);



        return Math.max(max, min);
    }
}