class Solution {
    public boolean isZeroArray(int[] arr, int[][] mat) {
        int n = arr.length;
        int[] diff = new int[n+1];
        int sum = 0;

        for(int i = 0; i < mat.length; i++){
            int start = mat[i][0];
            int end = mat[i][1];
            
            diff[start] += 1;
            diff[end + 1] -= 1;
        }

        // prefix sum
        for(int i = 0; i < n; i++){
            sum += diff[i];
            arr[i] -= sum;
            if(arr[i] > 0) return false;
        }

        System.out.println(Arrays.toString(diff));
        System.out.println(Arrays.toString(arr));
        System.out.println(sum);
        return true;

    }
}