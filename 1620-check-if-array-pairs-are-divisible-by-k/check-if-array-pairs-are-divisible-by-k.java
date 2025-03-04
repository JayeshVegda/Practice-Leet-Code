class Solution {
    public boolean canArrange(int[] arr, int k) 
    {
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for(int num : arr){
            int rem = num % k;
            if(rem < 0) rem = rem + k;
            mpp.put(rem, mpp.getOrDefault(rem, 0) + 1);
        }

        for(int rem : mpp.keySet())
        {
            if(rem == 0) {
            int finder = k - rem;
                if(mpp.get(rem) % 2 != 0) return false;
            }
            else 
            {
                int compRem = k - rem;

                if (!mpp.containsKey(compRem))  return false;

                if (!mpp.get(rem).equals(mpp.get(compRem))) 
                {
                    return false;
                }
            }
        }
        return true;
    }
}