class Solution {
    public int helper(int[] arr, int k) {
        if (k < 0) return 0;

        int n = arr.length;
        int i = -1, j = -1, count = 0, ans = 0;

        while (i < n - 1) // aquire winodw
        {
            i++;
            if (arr[i] == 1) count++;

            while (count > k)  // if sum bigger, we start to relase
            {
                j++;
                if (arr[j] == 1) count--;
            }

            ans += (i - j); // in the end, we find out our length
        }

        return ans;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0){
                nums[i] = 0;
            }else{
                nums[i] = 1;
            }
        }
        return helper(nums, k) - helper(nums, k - 1);
    }
}