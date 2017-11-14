//A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
//Return a deep copy of the list.

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;
        RandomListNode curr = head;
        //add copy nodes in between
        while(curr!= null){
            RandomListNode temp = curr.next;
            curr.next = new RandomListNode(curr.label);
            curr.next.next = temp;
            curr = temp;
        }
        
        //set arbitary pointer of copied nodes..
        curr = head;
        while(curr!= null){
            if(curr.random!=null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;   
        }
        //separate two lists and return copied list
        RandomListNode original = head, copy = head.next, result = head.next;
        
        while(original!= null && copy!=null){
            if(original.next != null)
                original.next = original.next.next;
            if(copy.next != null)
                copy.next = copy.next.next;
            
            original = original.next;
            copy = copy.next;
        }
        return result;
    }
}