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
    ListNode swap(ListNode head, int n, ListNode prev){
        if (head==null) return head;

        ListNode nextNode = swap(head.next, n+1, head);

        if (n%2==0){
            // reverse the pair
            prev.next = nextNode;
            head.next = prev;
            return head;
        }

        return nextNode==null ? head : nextNode;
    }
    public ListNode swapPairs(ListNode head) {
        return swap(head,1,new ListNode(-1));
    }
}
