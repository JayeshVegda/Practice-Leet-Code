class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int ans = 0;
        for(int left = 0; left < arr.length; left++){
            int sum = 0;
            for(int right = left; right < arr.length; right++){
                sum+=arr[right];

                if((right-left + 1) % 2 == 1 ){
                    ans+= sum;
                }
             }
            }
            return ans;
        }

    }
