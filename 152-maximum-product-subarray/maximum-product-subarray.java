class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int pref = 1;
        int suff = 1;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
           if(pref == 0) pref = 1;
           if(suff == 0) suff = 1;

           pref = pref * nums[i];
           suff = suff * nums[n-i-1];
            max = Math.max(max, Math.max(pref, suff));
        }

        return max;
    }
}