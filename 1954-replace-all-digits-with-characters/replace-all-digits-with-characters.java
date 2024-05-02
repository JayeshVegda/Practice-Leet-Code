class Solution {
    public String replaceDigits(String str) {
        int n  = str.length();
        StringBuilder result = new StringBuilder();



       


        for(int i = 0; i<n; i++){
            
            if(i%2 != 0){
                int currvalue = str.charAt(i) - 48;
                int lastindex = i-1;
                int lastchar = str.charAt(lastindex) + currvalue;
                char plus = (char) lastchar;
                result.append(plus);

            }else{
                result.append(str.charAt(i));
            }
        }

        
        return result.toString();

    }
}