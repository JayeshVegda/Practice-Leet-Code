class Solution 
{

    public boolean isValid(int[] freq){
        for(int val : freq){
            if(val > 1) return false;
        }

        return true;
    }
    public int minimumOperations(int[] nums) 
    {
        int ans = 0;
        int[] freq = new int[101];

        for(int num : nums){
            freq[num]++;
        }

        int n = nums.length;
        int i = 0;
        while(i < n)
        {
            boolean isValid = isValid(freq);
            if(isValid == true) return ans;
            if(isValid == false){
                ans++;
                freq[nums[i]]--;
                if(i+1 < n) freq[nums[i+1]]--;
                if(i+2 < n) freq[nums[i+2]]--;
                i = i + 3;
            }

        }
        return ans;    
    }
}