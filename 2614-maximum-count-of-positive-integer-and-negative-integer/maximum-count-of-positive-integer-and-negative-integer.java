class Solution {

    public int upperBound(int[] arr){
       int left = 0;
       int right = arr.length - 1;
       int ans = -1;
       while(left <= right){
        int mid = left + (right - left) / 2;
        
       
        if(arr[mid] >= 0){
            right = mid - 1;
        }else{
            ans = mid;
            left = mid + 1;
        }
       }
       return ans;
    }

    public int lowerBound(int[] arr)
    {
       int left = 0;
       int right = arr.length - 1;
       while(left <= right){
        int mid = left + (right - left) / 2;
        
        if(arr[mid] <= 0){
            left = mid + 1;
        }else{
            right = mid - 1;
        }
       }

       return left;
    }

    public int maximumCount(int[] arr) 
    {
        int negLast = upperBound(arr) + 1; // Count of negative numbers
        int posFirst = arr.length - lowerBound(arr); // Count of positive numbers
        return Math.max(negLast, posFirst);
    }
}