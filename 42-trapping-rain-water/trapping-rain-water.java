class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = arr[0];
        rightMax[n-1] = arr[n-1];
        // fill leftMax
        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(leftMax[i-1], arr[i]);
        }

        //fill right
        for(int i = n -2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i+1], arr[i]);
        }

        int trapped = 0;
        for(int i = 0; i < n; i++){
            int water_trapped = Math.min(leftMax[i], rightMax[i]) - arr[i] ;
            if(water_trapped >= 0){
                trapped += water_trapped;
            }
        }

        return trapped;

    }
}