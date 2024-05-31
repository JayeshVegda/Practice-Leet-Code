class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
       for(int i = 0; i<n/2; i++){
           char temp = s[i]; // h
           s[i] = s[n-i-1]; // h = s[2-0-1]
           s[n-i-1] = temp;
        }

    
    }
}