class Solution {

    public boolean isPossible(int[] piles, int speed, int target)
    {
        int n = piles.length;
        long sum = 0; // sum = 0 
        for(int pile : piles)
        {
            sum +=  pile/ speed; // 3 / 5  = 0
            
            if(pile % speed != 0) sum=sum+1;
        }

        return (sum <= target) ? true : false; // 5 
    }

    public int findMax(int[] piles){
        int max = 0;


        for(int pile : piles){
            max = Math.max(max, pile);
        }

        return max;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = findMax(piles);
        int ans = -1;

        while(left <= right){
            int mid = left + (right - left) / 2; // 5

            if(isPossible(piles, mid, h)) // speed 5 
            {
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return ans;
    }
}