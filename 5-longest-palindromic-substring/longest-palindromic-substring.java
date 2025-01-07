class Solution {
   public static String expand(String str, int l, int r){
        int n = str.length();
        while (l >= 0 && r < n && str.charAt(l) == str.charAt(r))
        {
           l--;
           r++;
        }
        return str.substring(l+1, r);
    }
    public static String longestPalindrome(String str) {
        int n = str.length();
        String longest = "";
        for(int i = 0; i < n; i++){
            String odd = expand(str, i, i);
            String even = expand(str, i, i+1);

            if(odd.length() > longest.length()){
                longest = odd;
            }

            if(even.length() > longest.length()){
                longest = even;
            }
        }

        return longest;
    }
}