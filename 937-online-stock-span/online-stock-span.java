class StockSpanner {
    Stack<Integer> price;
    Stack<Integer> stk;
    public StockSpanner() {
        stk = new Stack<>();
        price = new Stack<>();
    }
    
    public int next(int val) 
    {
        int count = 1;
        while(!stk.isEmpty() && stk.peek() <= val)
        {
            count += price.pop();
            stk.pop();
        }

        price.push(count);
        stk.push(val);

        return price.peek() ;

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */