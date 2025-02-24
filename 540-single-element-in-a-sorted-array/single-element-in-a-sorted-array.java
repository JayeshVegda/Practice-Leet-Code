class Solution {
    public int singleNonDuplicate(int[] arr) 
    {
        if(arr.length == 1) return arr[0];
        int left = 0;
        int right = arr.length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;

            if (mid % 2 == 1) {
                mid--; 
            }

            if (arr[mid] == arr[mid + 1]) 
            {
                left = mid + 2;
            } else {
                // If they don't match, the single element is on the left or at mid
                right = mid;
            }
                
        }

        return arr[left];
    }
}