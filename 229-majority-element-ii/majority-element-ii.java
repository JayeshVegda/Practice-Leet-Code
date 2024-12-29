class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> mylist = new ArrayList<>();

        int vot1 = 0;
        int vot2 = 0;
        int cad1 = Integer.MIN_VALUE;
        int cad2 = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++)
        {
            if(vot1 == 0 && nums[i] != cad2 ){
                cad1 = nums[i];
                vot1 = 1;
            }else if (vot2 == 0 && nums[i] != cad1){
                cad2 = nums[i];
                vot2 = 1;
            }else if(nums[i] == cad1) {vot1++;}
            else if(nums[i] == cad2) {vot2++;}
            else{vot1--; vot2--;}
        }

        vot1 = 0;
        vot2 = 0;

        for(int i = 0; i < nums.length; i++){
                if(nums[i] == cad1) vot1++;
                if(nums[i] == cad2) vot2++;
        }

        int mini = (int) nums.length / 3 + 1;
        if(vot1 >= mini) mylist.add(cad1);
        if(vot2 >= mini) mylist.add(cad2);


        return mylist;
    }
}