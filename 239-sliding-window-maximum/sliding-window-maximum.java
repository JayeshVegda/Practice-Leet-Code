class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];

        for(int i = n - 1; i >= 0; i--){
            while(st.size() > 0 && arr[i] >= arr[st.peek()]){
                st.pop();
            }   
            nge[i] = st.size() > 0 ? st.peek() : n;
            st.push(i);
        }
        
        int next = 0;
        int[] res = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) 
        {
            next = nge[i];
            int window = i + k;

            while(next < i + k && nge[next] < window)
            {
                next = nge[next];
            }

            if(next  < window){ 
                res[i] = arr[next];
            }else{
                res[i] = arr[i];
            }
           
        }
        return res;
    }

    
}