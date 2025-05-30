class Solution {
    public static void myswap(int[] nums, int one, int two){
        int temp = nums[one];
        nums[one] = nums[two];
        nums[two] = temp;
    }
    public void sortColors(int[] nums) 
    {
        //   int zero = 0;
        //   int first = 0;
        //   int sec = 0;

        //   for(int i =0; i < nums.length; i++){
        //     if(nums[i] == 0) zero++;
        //     if(nums[i] == 1) first++;
        //     if(nums[i] == 2) sec++;
        //   }
        //   int i = 0;

        //   while(zero != 0 || first != 0 || sec != 0)
        //   {
        //     if(zero > 0){
        //         nums[i] = 0;
        //         i++;
        //         zero--;
        //         continue;
        //     }

        //      else if(first > 0){
        //         nums[i] = 1;
        //         i++;
        //         first--;
        //        continue;
        //     }

        //     else if(sec > 0){
        //         nums[i] = 2;
        //         i++;
        //         sec--;
        //         continue;
        //     }
        //   }
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while(mid <= end){
            switch(nums[mid]){
                case 0:
                    myswap(nums, mid, start);
                    start++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    myswap(nums, mid, end);
                    end--;
                    break;
            }
        }
    }
}