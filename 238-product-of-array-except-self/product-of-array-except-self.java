class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        // fill left
        int[] left = new int[n];
        left[0] = 1;

        for(int i = 1; i < n; i++){
            left[i] = left[i-1] * nums[i-1];
        }

        // System.out.println(java.util.Arrays.toString(left));
        // fill right
        int[] right = new int[n];
        right[n-1] = 1;

        for(int i = n-2; i >= 0; i--){
            right[i] = right[i+1] * nums[i+1];
        }

        // System.out.println(java.util.Arrays.toString(right));
        // calculate
        int[] res = new int[n];
        for(int i = n-1; i >= 0; i--){
            res[i] = left[i] * right[i];
        }

        return  res;
    }
}