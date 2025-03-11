class Solution {
    public int finder(int[] arr, int k) {
        if (k < 0) return 0;

        int n = arr.length;
        int i = -1, j = -1, count = 0, ans = 0;

        while (i < n - 1) 
        {
            i++;
            if (arr[i] == 1) count++;

            while (count > k) 
            {
                j++;
                if (arr[j] == 1) count--;
            }
            
            ans += (i - j);
        }

        return ans;
    }

    public int numSubarraysWithSum(int[] arr, int k) {
        return finder(arr, k) - finder(arr, k - 1);
    }
}
