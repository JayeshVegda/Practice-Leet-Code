class Solution {
    public int maxDifference(String s, int k) {
        char[] c = s.toCharArray();
        int n = c.length;
        final int inf = Integer.MAX_VALUE / 2;
        int ans = -inf;
        for (int i = 0; i < 5; i++) {
            for (int j=0; j < 5; j++) 
            {
                if (i == j) {
                    continue;
                }

                int curA = 0, curB = 0;
                int prevA = 0, prevB = 0;

                int[][] temp = {{inf, inf}, {inf, inf}};
                for (int l = -1, r = 0; r < n; r++) {
                    curA += c[r] == '0' + i ? 1 : 0;
                    curB += c[r] == '0' + j ? 1 : 0;
                    while (r - l >= k && curB - prevB >= 2) {
                        temp[prevA & 1][prevB & 1] = Math.min(temp[prevA & 1][prevB & 1], prevA - prevB);
                        ++l;
                        prevA += (c[l] == '0' + i ? 1 :  0); 
                        prevB += (c[l] == '0' + j ? 1 :  0); 
                    }
                    ans = Math.max(ans, curA - curB - temp[curA & 1 ^ 1][curB & 1]);
                }
            }
        }
        return ans;
    }
}