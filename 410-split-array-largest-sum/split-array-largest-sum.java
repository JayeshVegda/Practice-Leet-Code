class Solution {

    public boolean isPossible(int[] arr, int ways, int target){
        int n = arr.length;
        int sum = 0;
        int way = 1;

        for(int i = 0; i < n; i++){
            int val = arr[i];

            if(val > target) return false;

            if(sum + val <= target){
                sum = sum + val;
            }else{
                sum = val;
                way++;
            }
        }

        return way <= ways;
    }

    public long findSum(int[] arr){
        long sum = 0;
        for(int i : arr){
            sum = sum + i;
        }

        return sum;
    }

    public int splitArray(int[] nums, int k) {
        long left = 0;
        long right = findSum(nums);
        int ans = -1;
        while(left <= right){
            long mid = left + (right - left) / 2;

            if(isPossible(nums, k, (int) mid)){
                ans = (int) mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }

        }

        return ans;
    }
}