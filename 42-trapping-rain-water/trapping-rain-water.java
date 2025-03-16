class Solution {
    public int trap(int[] arr) 
    {
        int total = 0;
        int l = 0, r = arr.length - 1;
        int lmax = 0, rmax = arr[r];

        while(l < r){
            if(arr[l] <= arr[r]){
                if(arr[l] < lmax){
                    total = total + lmax - arr[l];
                }else{
                    lmax = arr[l];
                }
                l++;
            }else{
                if(arr[r] < rmax){
                    total = total + rmax - arr[r];
                }else{
                    rmax = arr[r];
                }

                r--;
            }
        }

        return total;
    }
}