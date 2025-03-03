class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) 
    {
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
        {
          int val = nums[i];
            if (mpp.containsKey(val) && i - mpp.get(val) <= k) 
            {
                return true;
            }
            mpp.put(val, i);
        }

        return false;
    }
}