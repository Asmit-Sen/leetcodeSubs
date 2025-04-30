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
    int count=0;
     private ListNode recurse(ListNode node, int n) {
        if (node == null) return null;

        ListNode nextNode = recurse(node.next, n);
        count++;

        if (count == n + 1) {
            node.next = nextNode.next; // skip the n-th node from end
        }

        return node;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        recurse(dummy, n);
        return dummy.next;
    }
}
