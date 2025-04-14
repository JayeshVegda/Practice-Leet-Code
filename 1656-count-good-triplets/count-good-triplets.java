class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) 
    {
        int counter = 0;

        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                for(int k = j + 1; k < arr.length; k++){
                    int iTH = arr[i];
                    int jTH = arr[j];
                    int kTH = arr[k];

                    if(Math.abs(iTH -jTH) <= a && 
                        Math.abs(jTH - kTH) <= b &&
                        Math.abs(iTH - kTH) <= c) counter++;
                }
            }
        }

        return counter;
    }
}