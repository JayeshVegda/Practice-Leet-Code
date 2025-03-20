class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> stk = new Stack<>();

        for(int i = 0; i < arr.length; i++)
        {
            int val = arr[i];
            // not happend 
            if(val > 0){
                stk.push(val);
            }else
            {   
                 while(!stk.isEmpty() &&  stk.peek() > 0 && stk.peek() < Math.abs(val)){
                    stk.pop();
                }
                  

                if(!stk.isEmpty() && stk.peek() < 0){
                    stk.push(val);
                }
                else if(!stk.isEmpty() && stk.peek() == Math.abs(val)){
                    stk.pop();
                    continue;
                }
                else if(stk.isEmpty()){
                    stk.push(val);
                }

            }
        }

       int[] res = new int[stk.size()];
       int j = res.length - 1;
       while(!stk.isEmpty()){
        res[j--] = stk.pop();
       }

        return res;
    }
}