class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        int count = 0;

        while(i <= j)
        {
            int num = nums[i];

            if(num == val)
            {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;

                j--;
                count++;
            }else{
                i++;
            }
        }

        return nums.length - count;
    }
}