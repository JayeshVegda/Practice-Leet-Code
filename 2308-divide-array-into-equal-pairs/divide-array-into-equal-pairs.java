class Solution {
    public boolean divideArray(int[] nums) {
        int[] freq = new int[500+1];

        for(int num : nums){
            freq[num]++;
        }
        int count = 0;
        for(int key : freq){
            if(key != 0){
                count = count + (key/2);
            }
        }

        return ( (count) == (nums.length/2)) ? true : false;
    }
}