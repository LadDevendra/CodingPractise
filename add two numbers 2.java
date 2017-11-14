
//Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 8 -> 0 -> 7

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
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode temp1 = l1, temp2 = l2;
        while(temp1 != null){
            s1.push(temp1.val);
            temp1=temp1.next;
        }
        while(temp2 != null){
            s2.push(temp2.val);
            temp2=temp2.next;
        }
        int sum, carry = 0, currSum =0;
        ListNode resultHead = null;
        while(!s1.isEmpty() || !s2.isEmpty()){
             sum = 0;
             currSum =0;
            if(!s1.isEmpty())
                sum+=s1.pop();
            if(!s2.isEmpty())
                sum+=s2.pop();
            sum+= carry;
            if(sum/10>0)
                carry = sum/10;
            else
                carry =0;
            if(resultHead == null)
                resultHead = new ListNode(sum%10);
            else{
                ListNode temp = new ListNode(sum%10);
                temp.next = resultHead;
                resultHead = temp;
            }
        }
        if(carry!=0){
            ListNode temp = new ListNode(carry);
            temp.next = resultHead;
            resultHead = temp;
        }
        return resultHead;
    }
}