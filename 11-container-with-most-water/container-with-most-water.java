class Solution {
    public int maxArea(int[] height) {
         int max = 0;
        int left_pointer = 0;
        int right_pointer = height.length - 1;
        
        while (left_pointer < right_pointer) {
            int high = Math.min(height[left_pointer], height[right_pointer]);
            int width = right_pointer - left_pointer;
            int area = high * width;

            max = Math.max(max, area);

            if (height[left_pointer] < height[right_pointer]) {
                left_pointer++;
            } else {
                right_pointer--;
            }
        }
        
        return max;
    }
}