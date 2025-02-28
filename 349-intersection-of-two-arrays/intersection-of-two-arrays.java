class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> mpp = new HashMap<>();

        //first loop;
        for(int i : nums1){
            mpp.put(i, 1);
        }

        int[] output = new int[nums1.length + nums2.length];
        for(int i = 0; i < output.length; i++){
            output[i] = -1;
        }
        int counter = 0;

        for(int i : nums2){
            if(mpp.containsKey(i)){
                output[counter++] = i;
                mpp.remove(i);
            }
        }

        int stoploss = 0;
        counter = 0;
        while(output[counter] != -1)
        {
            stoploss++;
            counter++;
        }

        int[] newArr = new int[stoploss];
        for(int i = 0; i < newArr.length; i++){
            newArr[i] = output[i];
        }
        return newArr;
        
    }
}