class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        // insert into hashtable

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> mpp = new HashMap<>();


        for(int i = 0; i < nums1.length; i++)
        {
            int id = nums1[i][0];
            int val = nums1[i][1];

            mpp.put(id, mpp.getOrDefault(id, 0) + val);
            min = Math.min(min, id);
            max = Math.max(max, id);
        }
        for(int i = 0; i < nums2.length; i++)
        {
            int id = nums2[i][0];
            int val = nums2[i][1];

            mpp.put(id, mpp.getOrDefault(id, 0) + val);
            min = Math.min(min, id);
            max = Math.max(max, id);
        }
        System.out.print(mpp);
        int[][] output = new int[mpp.size()][2];
        int row = 0;
        for(int i = min; i <= max; i++)
        {
            if(mpp.containsKey(i)){
                int id = i;
                int val = mpp.get(id);

                output[row][0] = id;
                output[row][1] = val;

                row++;
            }
        }

        return output;
    }
}