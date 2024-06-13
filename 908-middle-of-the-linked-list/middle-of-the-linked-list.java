/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) 
        { this.val = val; 
          this.next = next; }
 * }
 */
class Solution {
    
    public ListNode middleNode(ListNode head) 
    {    
        ListNode faster = head;
        ListNode slower = head;
        
        while(faster != null && faster.next != null){
            slower = slower.next;
            faster = faster.next.next;
        }


        

        return slower;
    }

}