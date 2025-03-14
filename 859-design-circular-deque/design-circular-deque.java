class MyCircularDeque {
    int[] data;
    int head = 0; 
    int tail;  
    int size = 0; 
    int n;

    public MyCircularDeque(int k) {
        data = new int[k];
        n = data.length;
        tail = 1;
    }
    
    public boolean insertFront(int value) 
    {
        if(size == n) return false;
        data[head = ++head % n] = value;
        size++;
        return true;    
    }
    
    public boolean insertLast(int value) {
        if(size == n) return false;
        data[tail = (--tail + n) % n] = value;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(size == 0) return false;
        head = (--head + n ) % n;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(size == 0) return false;
        tail = ++tail % n;
        size--;
        return true;
    }
    
    public int getFront() {
        return size == 0 ? -1 : data[head];
    }
    
    public int getRear() {
        return size == 0 ? -1 : data[tail];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == data.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */