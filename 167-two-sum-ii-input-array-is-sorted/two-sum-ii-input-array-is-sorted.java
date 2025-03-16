class Solution {
    public int[] twoSum(int[] arr, int target) 
    {
        int i = 0;
        int j = arr.length - 1;

        while(i < j){
            int iVal = arr[i];
            int jVal = arr[j];
            int sum = iVal + jVal;
            if(sum == target) break;
            if(sum <= target){
                i++;
            }else{
                j--;
            }
        }
        return new int[]{i+1, j+1};
    }
}