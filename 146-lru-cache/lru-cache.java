class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache 
{
    Node head;
    Node tail;
    HashMap<Integer, Node> mpp;
    int size = 0;
    int cap = 0;

    public LRUCache(int capacity) 
    {
        cap = capacity;
        mpp = new HashMap<>();
        head = null;
        tail = null;
    }
    
    public int get(int key) 
    {
        //if contains --- add it last and return value;
        if(mpp.containsKey(key))
        {
            Node nn = mpp.get(key); // save it address
            remove(nn); // remove from that place
            addAtTail(nn); // add at last place
            return nn.val; // return value of that node
        }else{
            return -1; // that mean we dont containt it so return -1;
        }
    }
    
    public void put(int key, int value) 
    {
        // we are updating value of that key and make it LRU
        if(mpp.containsKey(key)){ 
            Node nn = mpp.get(key); // save it address
            remove(nn); // remove from that place
            addAtTail(nn); // add at last place
            nn.val = value; // updating value of that node or key
        }
        else{ // in case : where key doesnt exist on our data, so we remove fist if(limit excced) and add key and value at tail
            Node nn = new Node(key, value);
            mpp.put(key, nn);

            if(size >= cap){
               // this mean our size exceeed, so we have to removeFirst and then add only;
               int first = removeFirst(); // it will give me head key
               mpp.remove(first);
            }
            addAtTail(nn);
        }
    }

    public int removeFirst(){
        Node ret = head;
        if(size == 1){
              head = tail = null;
        }else{
            head = head.next;
            head.prev = null;

            ret.next = null;
        }
      
        size--;

        return ret.key;
    }

    public void removeLast(){
        if (size == 0) return;
        else if(size == 1){
            head = tail = null;
            size--;
        }else{
            Node pre = tail.prev;

            tail.prev = null;
            pre.next = null;

            tail = pre;
            size--;
        }
    }

    public void remove(Node nn)
    {
        if(nn == head){
           removeFirst();
        }    

        else if(tail == nn){
            removeLast();
        }

        else{
            Node nex = nn.next;
            Node pre = nn.prev;

            nex.prev = pre;
            pre.next = nex;

            nn.prev = nn.next = null;
            size--;
        }

    }

    public void addAtTail(Node nn)
    {
        // if empty
        if(size == 0){
            head = tail = nn;
        }else{
            nn.prev = tail;
            tail.next = nn;

            tail = nn;
        }
        
        size++;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */