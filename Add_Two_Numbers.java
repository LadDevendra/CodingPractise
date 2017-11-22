// Add Two Numbers

// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode prev = head;
        int sum = 0, carry = 0;
        //run through until on of the list is null..
        while(l1 != null && l2 != null){
            sum = l1.val + l2.val + carry;
            carry = sum/10;
            ListNode curr = new ListNode(sum%10);
            prev.next = curr;
            prev = curr;
            l1 = l1.next;
            l2 = l2.next;
        }
        //handle remaining list..
        while(l1 != null){
            sum = l1.val + carry;
            carry = sum/10;
            ListNode curr = new ListNode(sum%10);
            prev.next = curr;
            prev = curr;
            l1 = l1.next;
        }
        while(l2 != null){
            sum = l2.val + carry;
            carry = sum/10;
            ListNode curr = new ListNode(sum%10);
            prev.next = curr;
            prev = curr;
            l2 = l2.next;
        }
        //In case carry is present..
        if(carry != 0){
            ListNode curr = new ListNode(carry);
            prev.next = curr;
            prev = curr;
        }
        return head.next;
    }
}