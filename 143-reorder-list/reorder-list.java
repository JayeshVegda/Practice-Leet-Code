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
    private void mergeLists(ListNode first, ListNode second) {
            while (first != null && second != null) {
                ListNode temp1 = first.next;
                ListNode temp2 = second.next;

                first.next = second;
                if (temp1 == null) break;
                second.next = temp1;

                first = temp1;
                second = temp2;
            }
        }

    public ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode rev = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return rev;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;

        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null; // Split the list into two halves

        ListNode secondHalf = reverse(slow);
        mergeLists(head, secondHalf);
    }
}