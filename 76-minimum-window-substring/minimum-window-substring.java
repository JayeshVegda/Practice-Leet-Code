class Solution {
    public String minWindow(String s, String t) {
        int desire = t.length();
        int count = 0;
        String ans = "";
        HashMap<Character, Integer> dmpp = new HashMap<>();
        HashMap<Character, Integer> mpp = new HashMap<>();

        for(char ch : t.toCharArray()){
            dmpp.put(ch, dmpp.getOrDefault(ch, 0) + 1);
        }

        int i = -1;
        int j = -1;
        while(true)
        {
            boolean f1 = false;
            boolean f2 = false;

            // aquire
            while(i < s.length() - 1 && count < desire){
                i++;
                char ch = s.charAt(i);
              

                mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);

               if(mpp.getOrDefault(ch, 0) <= dmpp.getOrDefault(ch, 0)) {
                    count++;
                }
                
                f1 = true;
               
            }
            // relese
            while(j < i && desire == count) 
            {
                //work
                String temp = s.substring(j+1, i+1);
                if(ans.length() == 0 || ans.length() > temp.length()){
                    ans = temp;
                }

                // start to release
                j++;
                char ch = s.charAt(j);
                int freq = mpp.get(ch);

                if(freq == 1) mpp.remove(ch);
                else mpp.put(ch, freq - 1);


                if(mpp.getOrDefault(ch, 0) < dmpp.getOrDefault(ch, 0)) count--;
                f2 = true;
                
            }

            if(f1 == false && f2 == false) break;
        }

        return ans;
    }
}