/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int getLength(ListNode head){
        int counter = 0;
        while(head != null){
            head = head.next;
            counter++;
        }

        return counter;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        if(head == null || head.next == null) return null;
        ListNode temp = head;
        int size = getLength(head);

        if(n == size){
            return head.next;
        }

        for(int  i = 0; i < (size-n-1); i++){
            temp = temp.next;
        }

        temp.next =  temp.next.next;

        return head;


    }
}