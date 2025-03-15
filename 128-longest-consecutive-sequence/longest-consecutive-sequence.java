class Solution {
    public int longestConsecutive(int[] arr) {
        if(arr.length == 0) return 0;
        HashSet<Integer> stt = new HashSet<>();
        HashMap<Integer, ArrayList<Integer>> mpp =new HashMap<>();

        for(int num : arr){
            stt.add(num);
        }
        int n = arr.length;
        for(int num : stt) 
        {
                if(!stt.contains(num - 1)) 
                {
                    ArrayList<Integer> sequence = new ArrayList<>();
                    sequence.add(num);
                    
                    int next = num + 1;
                    while(stt.contains(next)) {
                        sequence.add(next);
                        next++;
                    }
                    
                    mpp.put(num, sequence);
                }
            }

        if(mpp.isEmpty()) return 1;

        int maxi = 0;
        for(int key : mpp.keySet())
        {
            ArrayList<Integer> list  = mpp.get(key);
            maxi = Math.max(maxi, list.size());
        }
        // System.out.println(mpp);

        return maxi;
    }
}