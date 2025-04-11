class Solution {
    public int count(String str) {
        int sum = 0;
        for (char ch : str.toCharArray()) {
            sum = sum + (ch - '0');
        }
        return sum;
    }

    public int countSymmetricIntegers(int low, int high) {
        int counter = 0;

        for(int i = low; i <= high; i++) {
            String str = Integer.toString(i);
            int str_leng = str.length(); 
            if(str_leng % 2 == 0) {
                int len = str_leng / 2;
                String st1 = str.substring(0, len);
                String st2 = str.substring(len, str.length());

                int s1 = count(st1);
                int s2 = count(st2);

                if(s1 == s2) {
                    counter++;
                }
            }
        }

        return counter;
    }
}