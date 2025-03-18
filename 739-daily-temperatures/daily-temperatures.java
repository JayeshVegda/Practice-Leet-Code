class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> stk = new Stack<>();
        int[] res = new int[temp.length];


        for(int i = temp.length-1; i >= 0; i--)
        {
     
            while(!stk.isEmpty() && temp[stk.peek()] <= temp[i]){
                stk.pop();
            }

            res[i] = (!stk.isEmpty()) ? stk.peek() - i : 0;
            stk.push(i);
        }

        return res;
    }
}