class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Integer> mpp = new HashMap<>();

        for(char c : s.toCharArray()){
            mpp.put(c, mpp.getOrDefault(c, 0) + 1);
        }

        for(char c : t.toCharArray()){
            if(mpp.containsKey(c))
            {
                if((mpp.getOrDefault(c, 0)) == 0) return false;
                mpp.put(c, mpp.getOrDefault(c, 0) - 1);
            }else{
                return false;
            }
        }

        return true;
    }
}