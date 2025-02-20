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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        int carry = 0;

        while(t1 != null || t2 != null || carry != 0)
        {
            int d1 = (t1 != null) ? t1.val : 0;
            int d2 = (t2 != null) ? t2.val : 0;

            int total = d1 + d2 + carry;

            ListNode nn = new ListNode(total % 10);
            temp.next = nn;
            temp = nn;
            carry = (total/10);

           if(t1 != null) t1 = t1.next;
           if(t2 != null) t2 = t2.next;
        }    

        return dummy.next;
    }
}