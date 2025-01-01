class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
      
        int[] iS = new int[200];
        int[] iT = new int[200];

        int len = s.length();
        if(len != t.length()){ return false; }

        for(int i = 0; i < len; i++){
            if(iS[s.charAt(i)] != iT[t.charAt(i)]) { return false; }

            iS[s.charAt(i)] = i + 1;
            iT[t.charAt(i)] = i + 1;


        } 

        return true;
    }
}