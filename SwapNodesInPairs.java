
//Swap Nodes in Pairs

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode result = new ListNode(0);
        ListNode prev = result;
        
        while(head != null){
            if(head.next == null)
                break;
            
            ListNode node3 = head.next.next;
            ListNode node2 = head.next;
            prev.next = node2; 
            head.next.next = head;
            head.next = node3;
            prev = head;
            head = head.next;
        }
        return result.next;
    }
}