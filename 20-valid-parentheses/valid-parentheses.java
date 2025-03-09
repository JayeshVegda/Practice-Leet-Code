class Solution {
    public boolean isValid(String s) 
    {
        Stack<Character> stk = new Stack<>();
        HashSet<Character> open = new HashSet<>();
        open.add('(');
        open.add('{');
        open.add('[');

        for(char ch : s.toCharArray())
        {
            if(open.contains(ch))  stk.push(ch);
            else
            {
                if(stk.isEmpty())  return false;  
                if(ch == ']' && stk.peek() == '[') stk.pop();
                else if(ch == '}' && stk.peek() == '{') stk.pop();
                else if(ch == ')' && stk.peek() == '(') stk.pop();
                else return false;
            }
        }

        return stk.isEmpty() ? true : false;
        
    }
}