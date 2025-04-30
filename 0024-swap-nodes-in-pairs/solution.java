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
    ListNode rev(ListNode cur, ListNode prev, int n){
        if(cur==null) return null;

        ListNode head_front=rev(cur.next, cur, n+1);

        if(n%2==0){
            cur.next=prev;
            prev.next=head_front;
            return cur;
        }
        return head_front==null?cur:head_front;
    }
    public ListNode swapPairs(ListNode head) {
        return rev(head, null,1);
    }
}
