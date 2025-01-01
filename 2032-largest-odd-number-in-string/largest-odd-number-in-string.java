class Solution {
    public static boolean isOdd(String str){
        Long num = Long.parseLong(str);
        if(num % 2 != 0){
            return true;
        }

        return false;
    }

    public String largestOddNumber(String num) {
        // if(isOdd(num)) return num;
        // int maxLen = 0;
        // String sub = "";

        // for(int i = 0; i < num.length(); i++){
        //     for(int j = i+1; j < num.length(); j++){
        //         String new_sub = num.substring(i,j);
        //         if(isOdd(new_sub) == true && new_sub.length() > maxLen){
        //             sub = new_sub;
        //             maxLen = new_sub.length();
        //         }
        //     }
        // }

        // return sub;

        String result = "";
        int ln = num.length() - 1;
        for (int i = ln; i >= 0; i--) {
            char ch = num.charAt(i);
            if (Character.getNumericValue(ch) % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return result;
    }
}