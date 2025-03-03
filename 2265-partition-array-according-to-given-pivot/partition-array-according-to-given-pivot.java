class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] output = new int[nums.length];
        int left = 0;
        int right = n - 1;

        // seraching for smaller
        for(int i = 0; i < n; i++)
        {
            int val = nums[i];
            if(val < pivot){
                output[left++] = val;
            }
        }

        // seraching for bigger
        for(int i = right; i >= 0; i--)
        {
            int val = nums[i];
            if(val > pivot){
                output[right--] = val;
            }
        }

        // filling 0;
        while(left <= right){
            output[right--] = pivot;
        }

        return output;
    }
}