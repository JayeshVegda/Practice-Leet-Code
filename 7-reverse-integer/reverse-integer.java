class Solution {
    public int reverse(int temp) {
        long res = 0;
        int unit;
        while (temp != 0){
            unit = temp % 10;
            res = res * 10 + unit;
            temp /= 10;

            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            {
                return 0;
            }
        }
        return (int)res;
    }
}