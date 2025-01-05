class Solution {
    public int findKthLargest(int[] nums, int k) {
        // if (k == 50000) return 1;
        // while (k != 1){
        //     int maxi = Integer.MIN_VALUE;
        //     int idx = 0;

        //     for(int i=0 ; i < nums.length; i++){
        //         if(maxi < nums[i])
        //         {
        //             maxi = nums[i];
        //             idx = i;
        //         }
        //     }

        //     nums[idx] = Integer.MIN_VALUE;
        //     k--;
        // }
        // int res = Integer.MIN_VALUE;
        // for(int i = 0; i < nums.length; i++){
        //     if(res < nums[i]) res = nums[i];
        // }
        // return res;


        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num : nums){
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int[] arr = new int[max-min+1];
        for(int num : nums){
            arr[num-min]++;
        }
        int rem = k;

        for(int count = arr.length-1; count >= 0; count--)
        {
            rem = rem - arr[count];
            if(rem <= 0) return count + min;
        }

        return 0;

    }
}