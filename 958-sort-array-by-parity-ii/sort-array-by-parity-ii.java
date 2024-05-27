class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int odd = 1;
        int even = 0;
        int[] ret = new int[nums.length];
        for(int a: nums){
            if(a%2==0){
                ret[even] = a;
                even += 2;
            }else{
                ret[odd] = a;
                odd+=2;
            }
        }
        return ret;
    }
}