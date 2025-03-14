class Solution {
    public boolean isPossible(int[] arr, long child, long target){
        long counter = 0;
        for(int num : arr){
            if(num < target) continue;

            counter = counter + (num / target);

            if(counter >= child) return true;
        }
        return false;
    }
    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        int max = 0;
        
        for (int candy : candies) {
            sum += candy;
            max = Math.max(max, candy);
        }
        
        if (sum < k) return 0;

        long left = 1;
        long right = max;
        int ans = -1;

        while(left <= right){
            long mid = left + (right - left) / 2;

            if(isPossible(candies, k, mid)){
                ans = (int) mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return ans;
    }

}