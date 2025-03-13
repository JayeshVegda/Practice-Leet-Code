class Solution {
    public boolean isPossible(int[] arr, int[][] mat, int right)
    {
        int n = arr.length;
        int sum = 0;
        int[] diff = new int[n+1];

        for(int i = 0; i < right; i++){
            int start = mat[i][0];
            int end = mat[i][1];
            int value = mat[i][2];

            diff[start] += value;
            diff[end+1] -= value; 
        }

        for(int i = 0; i < n; i++){
            sum += diff[i];
            if(sum < arr[i]) return false;
        }

        return true;
    }

    public int minZeroArray(int[] arr, int[][] mat) 
    {
        int n = arr.length;
        int left = 0;
        int right = mat.length;

        if(!isPossible(arr, mat, right)) return -1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(isPossible(arr, mat, mid)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}