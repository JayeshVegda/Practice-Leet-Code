class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1000000007;
        int n = arr.length;
        int prefix_sum = 0;
        int evencount = 1;
        int oddcount = 0;
        int res = 0;

        for(int i = 0; i < n; i++){
            int val = arr[i];
            prefix_sum = prefix_sum + val;
            if(prefix_sum % 2 == 0)
            {
                res = (res + oddcount) % MOD;
                evencount++;
            }
            else{
                res = (res + evencount) % MOD;
                oddcount++;
            }
        }

        return res;
    }
}