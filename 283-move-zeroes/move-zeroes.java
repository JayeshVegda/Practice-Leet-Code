class Solution {
    public void moveZeroes(int[] arr) {
        int start = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                arr[start] = arr[i];
                start++;
            }
        }

        for(int i = start; i < arr.length; i++){
            arr[i] = 0;
        }
    }
}