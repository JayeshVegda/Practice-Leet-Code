class Solution {
    public int hIndex(int[] arr) {
       int n = arr.length;
       int[] countSort = new int[n + 1];

       for(int i = 0; i < n; i++)
       {
            int val = arr[i];
            if(val >= n){
                countSort[n]++;
            }else{
                countSort[val]++;
            }
       }

       int count = 0;
       for(int i = n; i >= 0; i--)
       {
            count = count + countSort[i];
            if(count >= i) return i;
       }

       return 0;
        
    }
}