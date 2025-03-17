class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for(int num : nums){
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        for(int key : mpp.keySet()){
            int freq = mpp.get(key) / 2;
            count += freq;
        }

        return ( (count) == (nums.length/2)) ? true : false;
    }
}