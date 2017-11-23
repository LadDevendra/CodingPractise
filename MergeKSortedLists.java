// Merge K sorted Lists

// Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//Method 1 : Merge and sort Nlog(N) space and time... N = total number of elements in all K lists
//Method 2: Compare K, pick smallest and Keep appending to list -> Time : K*N, space : constant
//Method 3: Add first elements to PQ...keep removing and adding thereafter -> Time: O(log(k) *N), Space : constant

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        ListNode head = new ListNode(0);
        ListNode prev = head;
        
        // Natural ordering -> l1.compareTo(l2) gives q if l1 is greater than l2
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val == b.val? 0 : (a.val > b.val ? 1 : -1));
        
        for(ListNode n: lists){
            if(n != null)
                pq.add(n);
        }
        while(!pq.isEmpty()){
            ListNode temp = pq.remove();    
            prev.next = temp;
            prev = prev.next;
            if(prev.next != null)
                pq.add(prev.next);
        }
        return head.next;
    }
}