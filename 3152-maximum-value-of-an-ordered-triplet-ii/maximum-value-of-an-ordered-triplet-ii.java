class Solution {
    public long maximumTripletValue(int[] nums) {
        int ps= nums[0];
        int max_diff = 0;
        long res = 0;

        for(int i = 1; i < nums.length; i++)
        {
            res = Math.max(res, (long) max_diff * nums[i]);

            max_diff = Math.max(ps - nums[i], max_diff);
            ps = Math.max(ps,  nums[i]);
        }

        return res;
    }
}