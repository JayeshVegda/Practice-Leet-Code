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
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode last = head;
        ListNode dummy = head;

        if(head.next == null){
            return head = null;
        }

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        int counter = 0;

        while(last != slow){
            counter = counter + 1;
            last = last.next;
        }

        for(int i = 1; i<counter; i++){
            dummy = dummy.next;
        }

        dummy.next = slow.next;

        return head;
    }
}