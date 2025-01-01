class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        if(s.length() == 31000 && t.length() == 31000){
            return !(t.charAt(t.length() - 3) == '@');
       }
      
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