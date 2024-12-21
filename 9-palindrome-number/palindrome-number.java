class Solution {
    public boolean isPalindrome(int x) {
        int real = x;
        int rev = 0;

        while(x > 0)
        {
            int unit = x % 10;
            rev = (rev*10) + unit;
            x = x / 10;
        }
        
        if(rev == real) return true;

        return false;
    }
}