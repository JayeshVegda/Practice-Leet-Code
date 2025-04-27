class Solution {
    public int countSubarrays(int[] nums) {
        int counter = 0;
        int len = nums.length;
        for(int i = 0; i < len - 2; i++)
        {
            int first = nums[i];
            int sec = nums[i+1];
            int last = nums[i+2];
            int sum = first + last;

            System.out.println(sum);

            if((sum + sum) == sec) counter++;
        }

        return counter;
    }
}