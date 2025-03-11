class Solution {
    public int numberOfSubstrings(String s) 
    {
        int i = -1;
        int j = -1;
        int count = 0;
        
        int n = s.length();
        ArrayList<String> con = new ArrayList<>();
        HashMap<Character, Integer> mpp = new HashMap<>();
        while(true){
            boolean f1 = false;
            boolean f2 = false;

            // aquire
            while(i < n - 1)
            {
                i++;
                f1 = true;
                char ch = s.charAt(i);
                mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);

                if(mpp.size() == 3) {
                    count = count + (n - i);
                    break;
                }
            }

            while(j < i && mpp.size() == 3)
            {
                j++;
                f2 = true;
                char ch = s.charAt(j);
                if(mpp.get(ch) == 1) mpp.remove(ch);
                else {
                    mpp.put(ch, mpp.getOrDefault(ch, 0) - 1);
                    count = count + (n - i);
                    }

            }

            if(!f1 && !f2) break;
            //shrink
        }

        return count;
    }
}