class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for(int num : nums){
            mpp.put(num, mpp.getOrDefault(num, 0 )  + 1);

            if(mpp.get(num) >= 2){
                return true;
            }
        }
        
        return false;
    }
}