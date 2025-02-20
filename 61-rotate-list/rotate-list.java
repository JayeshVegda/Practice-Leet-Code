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
    public int get(ListNode head){
        int counter = 0;
        while(head != null){
            counter++;
            head = head.next;
        }

        return counter;
    }


    public ListNode rotateRight(ListNode head, int k) 
    {
        if(head == null || head.next == null || k == 0) return head;
        int len = get(head);  
        k = k % len;

        if(k == len) return head;

        ListNode temp = head;

        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = head;
        
        temp = head;
        for(int i = 0; i < (len-k) - 1; i++){
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;

        return head;
    }
}