class Solution 
{
    public static int[] findNextSmaller(int[] arr){
        int n = arr.length;
        int[] nextSmaller = new int[n];
        Stack<Integer> stk = new Stack<>();

        for(int i = n-1; i >= 0; i--){
            int val = arr[i];
            while(!stk.isEmpty() && arr[stk.peek()] >= val){
                stk.pop();
            }
            nextSmaller[i] = stk.isEmpty() ? n : stk.peek();
            stk.push(i);
        }

        return nextSmaller;
    }
    public static int[] findPrevSmaller(int[] arr){
        int n = arr.length;
        int[] prevSmaller = new int[n];
        Stack<Integer> stk = new Stack<>();

        for(int i = 0; i <n; i++)
        {
            int val = arr[i];
            while(!stk.isEmpty() && arr[stk.peek()] >= val){
                stk.pop();
            }
            prevSmaller[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(i);
        }

        return prevSmaller;
    }
    public int largestRectangleArea(int[] arr) 
    {

        int n = arr.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        nse = findNextSmaller(arr);
        pse = findPrevSmaller(arr);
        System.out.println("NEXT SMALLER " + Arrays.toString(nse));
        System.out.println("PREV SMALLER " + Arrays.toString(pse));
        
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            int w = nse[i] - pse[i] - 1;
            int a = arr[i] * w;
            max = Math.max(max, a);
        }

        return max;
    }
}