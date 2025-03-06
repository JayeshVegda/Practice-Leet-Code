class Solution {
    public int pivotIndex(int[] nums) 
    {
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();

        int lsum = 0;

        for(int i = 0; i < nums.length; i++){
            int val = nums[i];
            lsum = lsum + val;
            left.put(i, lsum);
        }

        int rsum = 0;
        for(int i = nums.length - 1; i >= 0; i--)
        {
            int val = nums[i];
            rsum = rsum + val;
            right.put(i, rsum);
        }
        
        System.out.println(left);
        System.out.println(right);

        for (int i = 0; i < nums.length; i++) 
        {
            int leftTotal = i > 0 ? left.get(i - 1) : 0;
            int rightTotal = i < nums.length - 1 ? right.get(i + 1) : 0;
            
            if (leftTotal == rightTotal) {
                return i;
            }
        }

        return -1;
        
    }
}