class FindSumPairs {
    int[] n1;
    int[] n2;
    HashMap<Integer, Integer> mpp = new HashMap<>();
    HashMap<Integer, Integer> freq1 = new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.n1 = Arrays.copyOf(nums1, nums1.length);
        this.n2 = Arrays.copyOf(nums2, nums2.length);

        for(int i = 0; i <nums2.length; i++){
            int val = nums2[i];
            mpp.put(val, mpp.getOrDefault(val, 0) + 1);
        }

        for (int val : nums1) {
            freq1.put(val, freq1.getOrDefault(val, 0) + 1);
        }
    }
    
    public void add(int index, int val) {
        int oldVal = n2[index];
        mpp.put(oldVal, mpp.get(oldVal) - 1);
        if (mpp.get(oldVal) == 0) {
            mpp.remove(oldVal);
        }

        //putting new value
        n2[index] += val;
        mpp.put(n2[index], mpp.getOrDefault(n2[index], 0) + 1);

    }
    
    public int count(int tot) 
    {
        int res = 0;
         for (Map.Entry<Integer, Integer> entry : freq1.entrySet()) 
         {
            int a = entry.getKey();
            int freq = entry.getValue();
            int b = tot - a;
            res += freq * mpp.getOrDefault(b, 0);
        }
        return res;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */