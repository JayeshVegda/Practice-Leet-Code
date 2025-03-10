import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        HashSet<Character> mpp = new HashSet<>();

        int i = 0, j = 0; 
        int ans = 0;

        while (i < s.length()) 
        {
            char ch = s.charAt(i);

            if (!mpp.contains(ch)) // Aquire the Window
            {
                mpp.add(s.charAt(i));
                ans = Math.max(ans, i - j + 1);
                i++;
            } 
            else  // Shrink window
            {
                char nch = s.charAt(j);
                mpp.remove(nch);
                j++; 
            }
        }

        return ans;
    }
}
