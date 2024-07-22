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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;

        int cnt=1,t=0;
        ListNode tail=head,temp=head;

        while(tail.next!=null)
        {
            cnt++;
            tail=tail.next;
        }
        tail.next=head;
        k=cnt-(k%cnt);
        while(temp!=null)
        {
            t++;
            if(t==k)
            {
                head=temp.next;
                temp.next=null;
                return head;
            }
            else temp=temp.next;
        }
        return head;

    }
}
