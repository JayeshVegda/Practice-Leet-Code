class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();

        //first loop;
        for(int i : nums1)
        {
            mpp.put(i, mpp.getOrDefault(i, 0) + 1);
        }

        
        int counter = 0;

        for(int i : nums2){
            if(mpp.containsKey(i))
            {
                if(mpp.get(i) >= 1){
                    arr.add(i);
                    mpp.put(i, mpp.getOrDefault(i, 0) - 1);
                }
            }
        }

        int[] newArr = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            newArr[i] = arr.get(i);
        }
        return newArr;
        
    }
}