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
    boolean ans = true;
    int c2=0;
    void f(ListNode node, int c1, int start[]){
        if (node==null) return;
        
        start[c1]=node.val;

        f(node.next, c1+1, start);

        c2++;
        if (start[c2]!=node.val) {
            ans = false;
            return;
        }
    }
    public boolean isPalindrome(ListNode head) {
        int start[]=new int[(int)1e5+1];
        f(head, 1, start);
        return ans;
    }
}
