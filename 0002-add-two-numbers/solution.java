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
        if(l1==null && l2==null) return null;
        
        int sum=0,carry=0;
        ListNode dummy =new ListNode(-1);
        ListNode sumHead =dummy;

        while(l1!=null || l2!=null)
        {
            sum=carry;
            if(l1!=null) sum+=l1.val;
            if(l2!=null) sum+=l2.val;

            carry=sum/10;
            sum%=10;

            ListNode newNode=new ListNode(sum);
            dummy.next=newNode;
            dummy=dummy.next;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        } 
        if(carry!=0)
        {
            ListNode last= new ListNode(1);
            dummy.next=last;
        }
        return sumHead.next;
    }
}
