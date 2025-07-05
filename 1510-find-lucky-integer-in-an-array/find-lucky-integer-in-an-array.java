class Solution {
    public int findLucky(int[] arr) {
        int[] freq = new int[501];

        for(int i : arr){
            freq[i]++;
        }

        int res = 0;
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++)
        {
            int val = arr[i]; // 2
            if(freq[val] == val) res = val; //2 
        }

        return res == 0 ? -1 : res;
    }
}