class Solution {

    public boolean isPossible(int[] piles, int speed, int target){
        int n = piles.length;
        long sum = 0;
        for(int pile : piles){
            sum +=  pile/ speed;
            if(pile % speed != 0) sum=sum+1;
        }

        return (sum <= target) ? true : false;
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
            int mid = left + (right - left) / 2;

            if(isPossible(piles, mid, h))
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