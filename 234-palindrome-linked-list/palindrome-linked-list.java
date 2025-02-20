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
    public ListNode mid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode rev(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode reverse = rev(head.next);

        head.next.next = head;
        head.next = null;

        return reverse;
    }

    public boolean isPalindrome(ListNode head) 
    {
        if(head == null || head.next == null) return true;

        ListNode midPoint = mid(head);
        ListNode revList =rev(midPoint);

        ListNode t1 = head;
        ListNode t2 = revList;

        while(t2 != null){
            if(t1.val != t2.val)
            {
                return false;
            }

            t1 = t1.next;
            t2 = t2.next;
        }

        return true;
    }
}