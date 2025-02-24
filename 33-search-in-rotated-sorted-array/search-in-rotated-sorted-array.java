class Solution {
    public int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            //if we found ans
            if(arr[mid] == target){
                return mid;
            }


            if(arr[mid] >= arr[start]){ // left sorted
                if(arr[start] <= target && target <= arr[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{ // right sorted
                if(arr[mid] <= target && target <= arr[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }

        }
        return -1;
    }
}