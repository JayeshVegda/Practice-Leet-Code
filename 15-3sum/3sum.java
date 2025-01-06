class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n-2; i++){
            int left = i + 1;
            int right = n - 1;

            while (right > left){
                int sum = nums[i] + nums[right] + nums[left];

                if(sum == 0){
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    result.add(triplet);
                    right--;
                    left++;
                }

                else if(sum > 0) {
                    right--;
                }else{
                    left++;
                }

            }
        }


        // int n = nums.length;
        // HashMap<Integer, Integer> mpp = new HashMap<Integer, Integer>();

        // for(int i = 0; i < n; i++){
        //     mpp.put(nums[i], i);
        // }

        // for(int i = 0; i < nums.length; i++){
            
        //     for(int j = i; j < nums.length; j++){
        //         List<Integer> list1 = new ArrayList<>();

        //         int diff = -(nums[j] - nums[i]); //0 
        //         if(mpp.containsKey(diff)){
        //             list1.add(nums[i]);
        //             list1.add(nums[j]);
        //             list1.add(diff);
        //             nestedList.add(list1);
        //         }

        //     }
        // }
        return new ArrayList<>(result);
    }
}