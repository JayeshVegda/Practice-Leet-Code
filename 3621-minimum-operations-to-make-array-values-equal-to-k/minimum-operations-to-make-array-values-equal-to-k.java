class Solution {
    public int minOperations(int[] nums, int k) 
    {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for(int val : nums){
            if(val < k) return -1;
            else if(val > k) mpp.put(val, mpp.getOrDefault(val, 0) + 1);
        }

        return mpp.size();
    }
}