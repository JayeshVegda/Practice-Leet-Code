class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int pro = 0;
        for(int i = 1; i < prices.length; i++){
            int val = prices[i];

            if(val < buy){
                buy = prices[i];
            }else if(val - buy > pro){
                pro = val - buy;
            }
        }

        return pro;
    }
}