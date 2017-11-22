
//Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 8 -> 0 -> 7

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * O(m+n) space (if we dont consider the result linkedList) and O(m+n) time.
 */
// class Solution {
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         Stack<Integer> s1 = new Stack<>();
//         Stack<Integer> s2 = new Stack<>();
//         ListNode temp1 = l1, temp2 = l2;
//         while(temp1 != null){
//             s1.push(temp1.val);
//             temp1=temp1.next;
//         }
//         while(temp2 != null){
//             s2.push(temp2.val);
//             temp2=temp2.next;
//         }
//         int sum, carry = 0, currSum =0;
//         ListNode resultHead = null;
//         while(!s1.isEmpty() || !s2.isEmpty()){
//              sum = 0;
//              currSum =0;
//             if(!s1.isEmpty())
//                 sum+=s1.pop();
//             if(!s2.isEmpty())
//                 sum+=s2.pop();
//             sum+= carry;
//             if(sum/10>0)
//                 carry = sum/10;
//             else
//                 carry =0;
//             if(resultHead == null)
//                 resultHead = new ListNode(sum%10);
//             else{
//                 ListNode temp = new ListNode(sum%10);
//                 temp.next = resultHead;
//                 resultHead = temp;
//             }
//         }
//         if(carry!=0){
//             ListNode temp = new ListNode(carry);
//             temp.next = resultHead;
//             resultHead = temp;
//         }
//         return resultHead;
//     }
// }

//O(1) space (if we dont consider the result linkedList) and O(m+n) time.
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        ListNode head = new ListNode(0);
        ListNode prev = head;
        int sum =0, carry = 0;
        
        while(l1!= null || l2!=null || carry!=0){
            int val1 = l1!=null ? l1.val : 0;
            int val2 = l2!=null ? l2.val : 0;
            sum = val1+ val2 + carry;
            carry = sum/10;
            ListNode curr = new ListNode(sum%10);
            prev.next = curr;
            prev = curr;
            //iterate ahead in non empty lists
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        
        return reverse(head.next);
    }
    
    public ListNode reverse(ListNode head){
        if(head == null)
            return null;
        
        ListNode prev = null, curr= head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    
}