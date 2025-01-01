class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1 ; i < s.length(); i++){
            if(s.charAt(i) == '('){
                sb.append('(');
                counter++;
            }else{
                if(counter == 0) {
                    i++;
                }else{
                    sb.append(')');
                    counter--;
                }
            }
        }
        return sb.toString();
    }
}