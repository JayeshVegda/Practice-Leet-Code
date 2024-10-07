class Solution {
    public int[] applyOperations(int[] arr) {
        int n = arr.length;

        for(int i = 0; i < n- 1; i++){
            if(arr[i] == arr[i+1]){
                arr[i] = arr[i] * 2;
                arr[i + 1] = 0;
            }
        }
        
        int idx = 0;
        for(int i = 0; i < n;i ++){
           if(arr[i] != 0){
            arr[idx] = arr[i];
            idx++;
           }
        }

        for(int i = idx; i < n; i++){
            arr[i] = 0;
        }
        return arr;
    }
}