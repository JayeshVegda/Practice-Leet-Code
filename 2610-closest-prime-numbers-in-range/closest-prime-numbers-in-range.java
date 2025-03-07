class Solution {
    public int[] closestPrimes(int left, int right) 
    {
        boolean[] valid = new boolean[right + 1];
        Arrays.fill(valid, true);
        valid[0] = false;
        valid[1] = false;

        for(int i = 2; i <= Math.sqrt(right); i++){
            if(valid[i] != false){
                for(int j = i + i; j <= right;  j = j + i)
                {
                    valid[j] = false;
                }
             }
        }
        int i = left;
        int diff = Integer.MAX_VALUE;
        int[] res = {-1, -1};

        while (i <= right) {
            if (valid[i]) {
                int j = i + 1;
                while (j <= right) 
                {
                    if (valid[j]) {
                        if (j - i < diff) {
                            diff = j - i;
                            res[0] = i;
                            res[1] = j;
                        }
                        break; // Found the closest valid j for this i
                    }
                    j++;
                }
            }
            i++;
        }
        return res;
    }
}