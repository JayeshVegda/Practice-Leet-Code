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
    // public static int getsize(ListNode head){
    //     ListNode temp = head;
    //     int counter = 0;
    //     while(temp != null){
    //         temp = temp.next;
    //         counter++;
    //     }
    //     return counter;
    // }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        // if(head.next == null){
        //     head = null;
        //     return head;
        // }


        ListNode temp = head;
        int counter = 0;
        while(temp.next != null){
            temp = temp.next;
            counter++;
        }
        counter+=1;

        if(counter - n == 0){
            head = head.next;
            return head;
        }


        int size = counter - n;
        int i = 0;
        ListNode finder = head;
        while(i < size-1)
        {
            finder = finder.next;
            i+=1;
        }

        finder.next = finder.next.next;

        return head;
        
    }
}