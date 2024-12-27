class Solution {
    public boolean checkIfPangram(String s) {
         s=s.toLowerCase();
          int frq[]=new int[26];
          int count=0;
          for(int i=0;i<s.length();i++){
               char ch=s.charAt(i);
               if(ch == ' ') continue;
               int idx = ch-'a';
               frq[idx]++;
          }

          for(int i=0;i<frq.length;i++){
               if(frq[i] == 0) return false;
          }

          return true;
    }
}