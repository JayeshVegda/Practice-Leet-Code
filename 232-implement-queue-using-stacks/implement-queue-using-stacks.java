class MyQueue {
        private Stack<Integer> stk1;
        private Stack<Integer> stk2;
        private int front;
    public MyQueue() {
        this.stk1 = new Stack<>();
        this.stk2 = new Stack<>();

    }
    
    public void push(int x) {
        if(stk1.empty()){
            front = x;
        }

        while(!stk1.isEmpty())
        {
            stk2.push(stk1.pop());
        }

        stk1.push(x);

        while(!stk2.isEmpty()){
            stk1.push(stk2.pop());
        }
    }
    
    public int pop() {
        if(stk1.isEmpty()){
                System.out.println("Your Queue is Empty.");
                return -1;
            }
        return stk1.pop();
    }
    
    public int peek() {
        if(stk1.isEmpty()){
                System.out.println("Your Queue is Empty.");
                return -1;
            }
        return stk1.peek();
    }
    
    public boolean empty() {
        return stk1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */