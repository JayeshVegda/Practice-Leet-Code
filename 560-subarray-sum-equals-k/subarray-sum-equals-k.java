class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int sum = 0;
        int max = 0;
        mpp.put(0, 1);

        for(int num : nums){
            sum = sum + num;
            int finder = sum - k;

            if(mpp.containsKey(finder)){
                max += mpp.get(finder);
            }

            mpp.put(sum, mpp.getOrDefault(sum, 0) + 1);
        }


        return max;
    }
}