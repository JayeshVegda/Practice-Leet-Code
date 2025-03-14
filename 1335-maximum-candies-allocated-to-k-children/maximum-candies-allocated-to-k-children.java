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
    public long findMin(int[] arr){
        long min = 0;
        for(int num : arr){
            min = Math.min(num, min);
        }

        return min;
    }

    public long findMax(int[] arr){
        long max = 0;
        for(int num : arr){
            max = Math.max(num, max);
        }

        return max;
    }

    public long totalSum(int[] arr){
        long sum = 0;
        for(int num : arr){
            sum += num;
        }

        return sum;
    }

    public int maximumCandies(int[] candies, long k) {
        if(totalSum(candies) < k) return 0;
        long left = findMin(candies) + 1;
        long right = findMax(candies);
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