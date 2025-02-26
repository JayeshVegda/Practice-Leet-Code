class Solution {
    public boolean isPossible(int[] arr, int days, int cap){
        int n = arr.length;
        int sum = 0;
        int day = 1;
        for(int i = 0; i < n; i++)
        {
            int val = arr[i];
            if(val > cap) return false;

             if(sum + val > cap){
                sum = val;  
                day = day + 1;
            } else {
                sum = sum + val;
            }


        }
        

        return (day <= days);
    }
    public long max(int[] arr){
        long max = 0;

        for(int i : arr){
            max = Math.max(i, max);
        }

        return max;
    }
    public long sum(int[] arr){
        long sum = 0;

        for(int i : arr){
            sum = sum + i;
        }

        return sum;
    }
    public int shipWithinDays(int[] weights, int days) {

        long left = max(weights);
        long right = sum(weights);

        if(days == 1) return (int) right ;

        int ans = -1;
        while(left <= right){
            long mid = left + (right - left) / 2;
            System.out.println(mid);
            if(isPossible(weights, days, (int) mid))
            {
                ans = (int) mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }

        }

        return ans ;
    }
}