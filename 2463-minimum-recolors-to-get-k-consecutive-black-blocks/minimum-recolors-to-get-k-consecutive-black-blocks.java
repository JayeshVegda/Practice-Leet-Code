class Solution {
    public int minimumRecolors(String s, int k)
    {
        int i = -1;
        int j = -1;
        int count = 0;
        int max = Integer.MAX_VALUE;

        HashMap<Character, Integer> mpp = new HashMap<>();

        while(true){
            boolean f1 = false;
            boolean f2 = false;

            //aquire
            while(i < s.length() - 1)
            {
                i++;
                f1 = true;
                
                char ch = s.charAt(i);
                mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);
                count++;
                
                int w = mpp.getOrDefault('W', 0);
                int b = mpp.getOrDefault('B', 0);
                if((b+w) == k)
                {
                    char chv = 'W';
                    int white = mpp.getOrDefault(chv, 0);
                    max = Math.min(white, max);
                    break;
                }
            }


            // release
            while(j < i)
            {
                j++;
                f2 = true;

                char ch = s.charAt(j);

                if(mpp.get(ch) == 1) mpp.remove(ch);
                else mpp.put(ch, mpp.getOrDefault(ch, 0) - 1);
                count--;


                if (count < k) {
                    break;
                }

                if (count == k) {
                    int whiteCount = mpp.getOrDefault('W', 0);
                    max = Math.min(whiteCount, max);
                }
            
            }

            if(!f1 && !f2) break;
        }


        return max;

    }
}