class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int num : nums){
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : mpp.keySet()) 
        {
            int frequency = mpp.get(key);

            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int[] res = new int[k];
        int counter = 0;
        for (int pos = bucket.length - 1; pos >= 0 && counter < k; pos--) 
        {
            if (bucket[pos] != null) 
            {
                for (Integer num : bucket[pos]) 
                {
                    res[counter++] = num;
                    if (counter == k) break; 
                }
            }
        }

        return res;
        
    }
}