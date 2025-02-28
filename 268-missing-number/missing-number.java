class Solution {
    public int missingNumber(int[] nums) {
        // int n = nums.length;
        // int total = n * (n + 1) / 2;
        // int sum = 0;

        // for(int i : nums){
        //     sum += i;
        // }

        // return total - sum;

        HashSet<Integer> set = new HashSet<>();

        for(int i : nums){
            set.add(i);
        }

        for(int i = 0; i <= nums.length; i++){
            if(!set.contains(i)) return i;
        }


        return -1;        
    }
}