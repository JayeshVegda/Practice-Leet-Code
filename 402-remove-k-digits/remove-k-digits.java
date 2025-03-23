class Solution {
    public String removeKdigits(String num, int k) 
    {
        int n = num.length();
        Stack<Integer> stk = new Stack<>();
        
        for(int i = 0; i < num.length(); i++){
            int digit = num.charAt(i) - '0';
            
            while(!stk.isEmpty() && k > 0 &&  stk.peek() > digit){
                stk.pop();
                k--;
            }

            stk.push(digit);
        }


        while (k > 0 && !stk.isEmpty()) 
        {
            stk.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty())
        {
            sb.append(stk.pop());
        }
        sb.reverse();

        // remove leading 0;
        while(sb.length() > 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        return sb.length() > 0 ? sb.toString() : "0" ;

    }
}