class Solution {

    public boolean isPossible(int[] arr, int target, int k, int day)
    {
        int n = arr.length;
        int counter = 0;
        int res = 0;
        for(int i = 0; i < n; i++){
            int val = arr[i];
            if(counter == k){
                res++;
                counter = 0;
            }

            if(val <= day){
                counter++;
            }else{
                counter = 0;
            }
        }

        if(counter == k){
                res++;
                counter = 0;
        }

        return res >= target;
    }

    public int findMin(int[] data){
        int min = Integer.MAX_VALUE;

        for(int file : data){
            min = Math.min(file, min);
        }

        return min;
    }

    public int findMax(int[] data){
        int max = Integer.MIN_VALUE;

        for(int file : data){
            max = Math.max(file, max);
        }

        return max;
    }

    public int minDays(int[] bloomDay, int m, int k) 
    {
        int left = findMin(bloomDay);
        int right = findMax(bloomDay);
        int ans = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(isPossible(bloomDay, m, k, mid)){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return ans;
    }
}