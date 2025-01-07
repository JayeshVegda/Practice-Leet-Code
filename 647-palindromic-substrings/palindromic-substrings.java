class Solution {
    public static int expand(String str, int l, int r){
        int n = str.length();
        int count = 0;
        while (l >= 0 && r < n && str.charAt(l) == str.charAt(r))
        {
            count++;
           l--;
           r++;
        }
        return count;
    }

    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
           count = count + expand(s, i, i);
           count = count + expand(s, i, i+1);
        }
        return count;
    }
}