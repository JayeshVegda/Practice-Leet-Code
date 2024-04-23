class Solution {
    public int scoreOfString(String s) {
       int val = 0;
        for(int i =0; i<s.length()-1; i++){
            int first = s.charAt(i);
            int sec = s.charAt(i+1);
            val += Math.abs(first - sec);
        }
        return val;
    }
}