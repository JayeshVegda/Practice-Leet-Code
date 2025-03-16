class Solution {
    public boolean isPossible(int[] arr, int cars, long t){
        int n = arr.length;
        long carsRepaired = 0;
        for(int num : arr){
            
            carsRepaired += (long) Math.sqrt((double) t / num);
            if(carsRepaired >= cars) return true;
        }

        return false;

    }
    public long findMax(int[] arr){
        long max = Integer.MIN_VALUE;
        for(int num : arr) max = Math.max(max, num);
        return max;
    }
    public long repairCars(int[] ranks, int cars) {
        long left = 0;
        long right = (long) ranks[0] * cars * cars;
        long ans = -1;
        while(left <= right){
            long mid = left + (right - left) / 2;

            if(isPossible(ranks, cars, mid))
            {
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
       return ans;
    }
}