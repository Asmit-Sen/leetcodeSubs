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
    ListNode merge( ListNode left, ListNode right)
    {
        if(left==null && right==null)
        return null;

        ListNode dummy= new ListNode(-1);
        ListNode t1=left,t2=right,temp=dummy;

        while( t1!=null && t2!=null)
        {
            if(t1.val<=t2.val)
            {
                temp.next=t1;
                t1=t1.next;
                temp=temp.next;
            }
            else {
                temp.next=t2;
                t2=t2.next;
                temp=temp.next;
            }
        }
        if(t1!=null) temp.next=t1;
        if(t2!=null) temp.next=t2;
        return dummy.next;
    }
    ListNode sortLL(ListNode head)
    {
        if(head==null || head.next==null) return head;

        ListNode slow=head,fast=head.next;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }// slow is middle
        ListNode leftHead=head,rightHead=slow.next;
        slow.next=null;

        leftHead= sortLL(leftHead);
        rightHead= sortLL(rightHead);
        return merge(leftHead,rightHead);
    }
    public ListNode sortList(ListNode head) {
        head=sortLL(head);
        return head;
    }
}
