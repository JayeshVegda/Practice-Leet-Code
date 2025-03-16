class Solution {
    public int[] twoSum(int[] arr, int target) 
    {

        for (int i = 0; i < arr.length; i++) 
        {
            for (int j = i + 1; j < arr.length; j++)
             {
                if (arr[i] + arr[j] == target) {
                    return new int[]{i+1, j+1}; // 1-indexed return
                }
            }
        }

        return new int[]{-1, -1};
    }
}