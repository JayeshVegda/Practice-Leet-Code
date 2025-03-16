class Solution {
    public int maxArea(int[] arr) {
        int n = arr.length;

        int left = 0;
        int right = n - 1;
        int res = 0;
        while(left < right){
            int lval = arr[left];
            int rval = arr[right];

            int min = Math.min(lval, rval);

            // calc Area
            int area = min * (right - left);
            res = Math.max(area, res);

            if(min == lval){
                left++;
            }else{
                right--;
            }
        }

        return res;
    }
}