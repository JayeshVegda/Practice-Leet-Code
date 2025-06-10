class Solution {
    public boolean canJump(int[] nums) {
        int maxIdx = 0;

        for(int i = 0; i < nums.length; i++){
           int val = i + nums[i];
           if(i > maxIdx) return false;
           maxIdx = Math.max(maxIdx, val);
        }

        return true;
    }
}