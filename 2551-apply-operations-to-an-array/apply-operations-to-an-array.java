class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < n - 1; i++)
        {
            int val = nums[i];
            int valnext = nums[i+1];

            if(val == valnext)
            {
                nums[i] = nums[i] * 2;
                nums[i+1] = 0;
            }
        }

        System.out.println(Arrays.toString(nums));

        // move 0 to the end;
        int first = 0;
        int sec = 0;

        while(sec < n  && first < n ){
            if(nums[first] == 0){
                while(sec < n && nums[sec] == 0  ){
                    sec++;
                }

                //swap
                if(sec < n) {
                    nums[first] = nums[sec];
                    nums[sec] = 0;
                }

                //reset pointer;
                first++;
            }else{
                first++;
                sec++;
            }
        }

        return nums;
    }
}