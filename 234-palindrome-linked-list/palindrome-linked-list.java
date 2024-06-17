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

    public static ListNode findmid(ListNode head){

        if(head == null){
            return null;
        }
        ListNode faster = head;
        ListNode slower = head;

        while(faster != null && faster.next != null){
            slower = slower.next;
            faster = faster.next.next;
        }

        return slower;
    }
    public boolean isPalindrome(ListNode head) {
        // base case
        if(head == null || head.next == null){
            return true;
        }


        //step 1 - find mid
        ListNode middle = findmid(head);


        //stap 2 - reverse mid+1
        ListNode prev = null;
        ListNode curr = middle;
        ListNode next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }


        //step 3 - check lp == rp
        ListNode right = prev;
        ListNode left = head;

        while(right!=null){
            if(left.val  != right.val){
                return false;
            }

            left = left.next;
            right = right.next;
        }
    
        return true;

    }
}