class Solution {
    public boolean isPerfectSquare(int x) {
         if(x == 1) return true;
        int left = 0;
        int right = x / 2;
        // if(x > 10){
        //      right = x / 3 ;
        // }else{
        //      right = x / 2;
        // }
        
        int ans = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            long val = (long) mid * mid;
            if(val == x) return true;
            if(val < x){
                
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return false;
    }
}