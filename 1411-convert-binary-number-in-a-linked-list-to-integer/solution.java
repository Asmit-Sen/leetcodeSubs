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
    int pos=0;
    int rev(ListNode node){
        if(node==null) return 0;

        return rev(node.next) + (int)Math.pow(2,pos++) * node.val ;
    }
    public int getDecimalValue(ListNode head) {
        if(head==null) return 0;
        return rev(head);
    }
}
