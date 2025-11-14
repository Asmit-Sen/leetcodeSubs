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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode ptr = dummy;
        int carry=0, v1=0, v2=0;
        while(l1!=null || l2!=null){
            if(l1!=null) v1=l1.val ;
                else v1=0;
            if(l2!=null) v2=l2.val ;
                else v2=0;
            
            int sum=v1+v2+carry;
            ptr.next=new ListNode(sum%10);
            ptr=ptr.next;
            if(sum>=10) carry=1;
            else carry=0;
            
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
            
        }
        
        if(carry!=0){
             ptr.next = new ListNode(carry);
        }
        
        return dummy.next;
    }
}
