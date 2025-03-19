class Solution {
    public int[] nextGreaterElements(int[] arr) 
    {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stk = new Stack<>();
        Arrays.fill(res, -1);
        for(int i = 0; i < n; i++)
        {
            int val = arr[i];

            while(!stk.isEmpty() && arr[stk.peek()] < val){
                res[stk.pop()] = arr[i];
            }
            stk.push(i);
        }

         for(int i = 0; i < n; i++)
        {
            int val = arr[i];

            while(!stk.isEmpty() && arr[stk.peek()] < val){
                res[stk.pop()] = arr[i];
            }
            stk.push(i);
        }


        System.out.println(stk);

        return res;
    }
}