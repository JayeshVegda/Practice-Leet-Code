/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public void printll(Node head){
        while(head != null){
            System.out.print(head.val + "");
            head = head.next;
        }

        System.out.println();
    }
    public Node copyRandomList(Node head) 
    {
        if(head == null) return head;
       
        // insert node in between
        Node temp = head;
        while(temp != null){
            Node nn = new Node(temp.val);
            nn.next = temp.next;
            temp.next = nn;
            temp = nn.next;
        }    
      
        // asign random pointer

        temp = head;
        while(temp != null){
            if(temp.random != null){
                temp.next.random = temp.random.next;
            }

            temp = temp.next.next;
        }
     

        // detatch
        temp = head;
        Node clone = head.next;
        Node ctemp = clone;

        while(ctemp.next != null)
        {
           temp.next = temp.next.next;
           ctemp.next = ctemp.next.next;

           temp = temp.next;
           ctemp = ctemp.next;
        }

        temp.next = null;
        ctemp.next = null;
        return clone;
    }
}