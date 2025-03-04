class Solution {
    public boolean canArrange(int[] arr, int k) 
    {
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for(int num : arr){
            int rem = ((num % k) + k) % k;
            mpp.put(rem, mpp.getOrDefault(rem, 0) + 1);
        }
        int counter = 0;

        for(int rem : mpp.keySet())
        {
            int finder = k - rem;
            if(rem == 0) {
                if(mpp.get(rem) % 2 != 0) return false;
            }else if(mpp.containsKey(finder))
            {
                int rem_freq = mpp.get(rem);
                int finder_freq = mpp.get(finder);

                if(rem_freq != finder_freq) return false;
            }else{
                return false;
            }
        }

        return true;
    }
}