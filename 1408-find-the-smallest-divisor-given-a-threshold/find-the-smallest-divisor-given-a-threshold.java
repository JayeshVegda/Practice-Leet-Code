class Solution {
    public boolean isPossible(int[] arr, int target, int mid){
        int n = arr.length;
        int res = 0;

        for(int i : arr){
            int nnum = i / mid;
            int nrem = i % mid;

            res = res + nnum;
            if(nrem != 0) res = res + 1;
        }

        return res <= target;
    }
    public long findMax(int[] arr){
        long max = Integer.MIN_VALUE;

        for(int i : arr){
            max = Math.max(i, max);
        }

        return max;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        long left = 1;
        long right = findMax(nums);
        int ans = -1;

        while(left <= right){
            long mid = left + (right - left) / 2;

            if(isPossible(nums, threshold, (int) mid)){
                ans = (int) mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return ans;
    }
}