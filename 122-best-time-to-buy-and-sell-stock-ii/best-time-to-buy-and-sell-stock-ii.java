class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for(int i = 1; i < prices.length; i++){
            int val = prices[i];

            if(val > prices[i - 1]){
                profit += (val - prices[i-1]);
            }
        }

        return profit;
    }
}