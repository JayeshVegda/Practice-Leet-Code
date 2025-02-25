class Solution {
    public int mySqrt(int x) {
        if(x == 1) return 1;
        int left = 0;
        int right = 0;
        if(x > 10){
             right = x / 3 ;
        }else{
             right = x / 2;
        }
        
        int ans = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            long val = (long) mid * mid;
            if(val == x) return mid;
            if(val < x){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return ans;
    }
}