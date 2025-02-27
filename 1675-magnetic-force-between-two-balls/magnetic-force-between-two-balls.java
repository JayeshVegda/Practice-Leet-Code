class Solution {
    public boolean isPossible(int[] arr, int balls, int dist){
        int n = arr.length;
        int ball = 1;
        int sum = arr[0];

        for(int i = 1; i < n; i++){
            if(arr[i] - sum >= dist)
            {
                ball++;
                sum = arr[i];
            }

        }
        if(ball >= balls) return true;


        return false;
    }
    public int maxDistance(int[] arr, int m) {
        Arrays.sort(arr);
        int left = 1;
        int right = arr[arr.length - 1];
        int ans = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;    
            System.out.println("left = " + left + " mid = " + mid + " right = " + right);

            if(isPossible(arr, m, mid)){
                ans = mid;
                left = mid + 1;
            }else{
               right = mid - 1;
            }

        }

        return ans;
    }
}