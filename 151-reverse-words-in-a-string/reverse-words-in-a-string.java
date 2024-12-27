class Solution {
    public String reverseWords(String s) {
        // String[] str = s.split(" ");
        // String res = "";
        // // for(int i = str.length - 1; i >= 0 ; i--){
        // //     String curr_str = str[i];
        // //     res = res + curr_str + " ";
        // // }
   
        String[] str = s.trim().split("\\s+");
        String res = "";

        for (int i = str.length - 1; i > 0; i--) 
        {
            res = res + str[i] + " ";
        }
        return res + str[0];
    }
}