class Solution {
    public int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int num : arr){
            max = Math.max(num, max);
        }
        return max;
    }

    public int findMin(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int num : arr){
            min = Math.min(num, min);
        }

        return min;
    }
    public boolean isPossible(int[] arr, int k, int target){
        int n = arr.length;
        int count = 0;
        int i = 0;
        while(i < n){
            if(arr[i] <= target){
                i = i + 2; // pointer adjusting 
                count = count + 1; // mean we robbed k house
            }else{
                i++;
            }

            if(count == k) return true;
        }
        return false;
    }

    public int minCapability(int[] nums, int k) 
    {
        int left = findMin(nums);
        if(k == 1) return left;
        int right = findMax(nums);
        int ans = -1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;

            if(isPossible(nums, k, mid)){
                ans = mid;
                right = mid - 1;
            }else
            {
                left = mid + 1;
            }
        }
        return ans;

    }
}