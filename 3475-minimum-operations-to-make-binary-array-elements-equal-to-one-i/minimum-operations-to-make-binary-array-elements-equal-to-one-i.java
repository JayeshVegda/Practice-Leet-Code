class Solution {
    public void flip(int[] arr, int idx)
    {
        if(arr[idx] == 0) arr[idx] = 1;
        if(arr[idx] == 1) arr[idx] = 0;
    }
    public int minOperations(int[] arr) {
        int res = 0;
        int n = arr.length;

        for(int i = 0; i < n - 2; i++)
        {
            int val = arr[i];
            if(val == 0){
               arr[i] = arr[i] == 0 ? 1 : 0;
               arr[i+1] = arr[i+1] == 0 ? 1 : 0;
               arr[i+2] = arr[i+2] == 0 ? 1 : 0;
               res += 1;
            }
        }

        if(arr[n-1] == 0 || arr[n-2] == 0) return -1;
        System.out.println(Arrays.toString(arr));

        return res;
    }
}