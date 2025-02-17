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
    public ListNode partition(ListNode head, int x) 
    {
        ListNode less = new ListNode(0);
        ListNode l = less;
        ListNode right = new ListNode(0);
        ListNode r = right;

        ListNode temp = head;

        while(temp != null){
            ListNode nn = new ListNode(temp.val);

            if(temp.val < x)
            {
                l.next = nn;
                l = nn;
            }
            else{
               r.next = nn;
               r = nn;
            }

            temp = temp.next;
        }


        l.next = right.next;

        return less.next;

    }
}