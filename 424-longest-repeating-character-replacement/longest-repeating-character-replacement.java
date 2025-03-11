class Solution {
    public int maxFreq(HashMap<Character, Integer> mpp) {
        int max = Integer.MIN_VALUE;
        for(Character key : mpp.keySet()) {
            int data = mpp.get(key);
            max = Math.max(data, max);
        }
        return max;
    }

    public int characterReplacement(String s, int k) {
        int i = -1;
        int j = -1;
        int n = s.length();
        int res = 0;
        HashMap<Character, Integer> mpp = new HashMap<>();

        while(true) {
            boolean b1 = false;
            boolean b2 = false;
            
            // Acquire characters
            while(i < n - 1) {
                i++;
                b1 = true;

                char ch = s.charAt(i);
                mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);

                int curr_max = maxFreq(mpp);
                int windowSize = i - j;
                int charsToReplace = windowSize - curr_max;
                
                // If we need more replacements than k, break and release characters
                if(charsToReplace > k) {
                    break;
                }
                
                // Update result with current valid window
                res = Math.max(res, windowSize);
            }

            // Release characters
            while(j < i) {
                j++;
                b2 = true;

                char ch = s.charAt(j);
                mpp.put(ch, mpp.get(ch) - 1);
                
                // Remove entry if count becomes 0
                if(mpp.get(ch) == 0) {
                    mpp.remove(ch);
                }
                
                int curr_max = maxFreq(mpp);
                int windowSize = i - j;
                int charsToReplace = windowSize - curr_max;
                
                // If window becomes valid again, break
                if(charsToReplace <= k) {
                    break;
                }
            }
            
            // Exit condition: no more progress possible
            if(!b1 && !b2) break;
        }

        return res;
    }
}